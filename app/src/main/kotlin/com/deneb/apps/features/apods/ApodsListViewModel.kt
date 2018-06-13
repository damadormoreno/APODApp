package com.deneb.apps.features.apods

import android.arch.lifecycle.MutableLiveData
import com.deneb.apps.core.platform.BaseViewModel
import javax.inject.Inject

class ApodsListViewModel
@Inject constructor(private val getApods: GetApods) : BaseViewModel() {
    var apods: MutableLiveData<List<ApodView>> = MutableLiveData()

    fun loadApods() = getApods.execute({it.either(::handleFailure, ::handleApodsList)},
            GetApods.Params("2018-06-01", "2018-06-13"))

    private fun handleApodsList(apods: List<Apod>) {
        this.apods.value = apods.map { ApodView(it.date, it.url, it.title) }
    }
}