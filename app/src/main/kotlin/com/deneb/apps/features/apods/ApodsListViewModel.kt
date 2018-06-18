package com.deneb.apps.features.apods

import android.arch.lifecycle.MutableLiveData
import com.deneb.apps.core.extension.formatToSringDate
import com.deneb.apps.core.extension.threMonthsless
import com.deneb.apps.core.platform.BaseViewModel
import java.util.*
import javax.inject.Inject

class ApodsListViewModel
@Inject constructor(private val getApods: GetApods) : BaseViewModel() {
    var apods: MutableLiveData<List<ApodView>> = MutableLiveData()
    val date: Date = Date()

    fun loadApods() = getApods.execute({it.either(::handleFailure, ::handleApodsList)},
            GetApods.Params(date.threMonthsless(date), date.formatToSringDate()))

    private fun handleApodsList(apods: List<Apod>) {
        this.apods.value = apods.map {
            ApodView(it.date, it.url, it.title, it.explanation, it.media_type)
        }.asReversed()
    }
}