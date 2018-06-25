package com.deneb.apps.features.apods

import android.arch.lifecycle.MutableLiveData
import com.deneb.apps.core.interactor.UseCase
import com.deneb.apps.core.platform.BaseViewModel
import javax.inject.Inject

class ApodViewModel
@Inject constructor(private val getApod: GetApod) : BaseViewModel() {

    var apod: MutableLiveData<ApodView> = MutableLiveData()

    fun loadApod() = getApod.execute({it.either(::handleFailure, ::handleApod)}, UseCase.None())

    private fun handleApod(apod: Apod) {
        this.apod.value = ApodView(apod.date, apod.url, apod.title, apod.explanation, apod.media_type)
    }
}