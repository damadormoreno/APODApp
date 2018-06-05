package com.deneb.apps.features.apods

import com.deneb.apps.core.exception.Failure
import com.deneb.apps.core.functional.Either
import com.deneb.apps.core.platform.NetworkHandler
import retrofit2.Call
import javax.inject.Inject

interface ApodRepository {
    fun apods(startDate: String, endDate: String) : Either<Failure, List<Apod>>
    fun apodOfTheDay() : Either<Failure, Apod>

    class Network
    @Inject constructor(private val networkHandler: NetworkHandler,
                        private val service: ApodsService) : ApodRepository {
        override fun apods(startDate: String, endDate: String): Either<Failure, List<Apod>> {
            return when (networkHandler.isConnected) {
                true -> request(service.getRecentsApods(startDate, endDate), {it.map {it.toApod()  }}, emptyList())
                false, null -> Either.Left(Failure.NetworkConnection())
            }
        }

        override fun apodOfTheDay(): Either<Failure, Apod> {
            return when (networkHandler.isConnected) {
                true -> request(service.getApod(), {it.toApod()}, ApodEntity.empty())
                false, null -> Either.Left(Failure.NetworkConnection())
            }

        }

        private fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
            return try {
                val response = call.execute()
                when (response.isSuccessful) {
                    true -> Either.Right(transform((response.body() ?: default)))
                    false -> Either.Left(Failure.ServerError())
                }
            } catch (exception: Throwable) {
                Either.Left(Failure.ServerError())
            }
        }
    }


}