package com.deneb.apps.features.apods

import com.deneb.apps.core.exception.Failure
import com.deneb.apps.core.functional.Either
import com.deneb.apps.core.interactor.UseCase
import javax.inject.Inject

class GetApod
@Inject constructor(private val apodRepository: ApodRepository) :
        UseCase<Apod, UseCase.None>() {
    override suspend fun run(params: None) = apodRepository.apodOfTheDay()
}