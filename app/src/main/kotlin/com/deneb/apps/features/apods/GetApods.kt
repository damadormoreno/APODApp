package com.deneb.apps.features.apods

import com.deneb.apps.core.interactor.UseCase
import com.deneb.apps.core.interactor.UseCase.None
import javax.inject.Inject

class GetApods
@Inject constructor(private val apodsRepository: ApodRepository) :
    UseCase<List<Apod>, None>() {

    override suspend fun run(params: None) = apodsRepository.apods()

}