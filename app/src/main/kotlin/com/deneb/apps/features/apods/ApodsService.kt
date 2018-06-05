package com.deneb.apps.features.apods

import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApodsService
@Inject constructor(retrofit: Retrofit) : ApodsApi {

    private val apodsApi by lazy { retrofit.create(ApodsApi::class.java) }

    override fun getApod(): Call<ApodEntity> = apodsApi.getApod()

    override fun getRecentsApods(startDate: String, endDate: String): Call<List<ApodEntity>> {
        return apodsApi.getRecentsApods(startDate, endDate)
    }




}