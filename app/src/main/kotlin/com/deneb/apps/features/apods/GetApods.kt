package com.deneb.apps.features.apods

import com.deneb.apps.core.interactor.UseCase
import javax.inject.Inject

class GetApods
@Inject constructor(private val apodsRepository: ApodRepository) :
    UseCase<List<Apod>, GetApods.Params>() {

    override suspend fun run(params: Params) = apodsRepository.apods(params.startDate, params.endDate)

    data class Params(val startDate: String, val endDate: String)



}