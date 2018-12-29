package com.deneb.apps.features.apods

import android.arch.lifecycle.MutableLiveData
import com.deneb.apps.core.platform.BaseViewModel
import com.deneb.apps.features.movies.PlayMovie
import javax.inject.Inject

class ApodDetailViewModel
@Inject constructor(private val playMovie: PlayMovie) : BaseViewModel()
{

}