package com.deneb.apps.features.apods

import com.deneb.apps.core.exception.Failure
import com.deneb.apps.core.functional.Either

interface ApodRepository {
    fun apods() : Either<Failure, List<Apod>>
    fun apodOfTheDay() : Either<Failure, Apod>


}