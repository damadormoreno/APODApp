package com.deneb.apps.features.apods

import android.arch.lifecycle.MutableLiveData
import com.deneb.apps.core.extension.AppPreferences
import com.deneb.apps.core.extension.oneWeekless
import com.deneb.apps.core.platform.BaseViewModel
import java.util.*
import javax.inject.Inject

class ApodsListViewModel
@Inject constructor(private val getApods: GetApods) : BaseViewModel() {
    var apods: MutableLiveData<List<ApodView>> = MutableLiveData()
    val date: Date = Date()
    val preferences = AppPreferences.getPreferences()


    fun loadApods() = getApods.execute({it.either(::handleFailure, ::handleApodsList)},
            GetApods.Params(date.oneWeekless(), preferences.getString("dateApod","")))

    private fun handleApodsList(apods: List<Apod>) {
        this.apods.value = apods.map {
            ApodView(it.date, it.url, it.title, it.explanation, it.media_type)
        }.asReversed()
    }
}