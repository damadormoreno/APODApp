package com.deneb.apps.features.apods


import android.os.Bundle
import android.view.View
import com.deneb.apps.R
import com.deneb.apps.core.exception.Failure
import com.deneb.apps.core.extension.*
import com.deneb.apps.core.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_apod.*
import org.jetbrains.anko.support.v4.toast


class ApodFragment : BaseFragment() {

    private lateinit var apodViewModel: ApodViewModel

    override fun layoutId(): Int = R.layout.fragment_apod

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        apodViewModel = viewModel(viewModelFactory) {
            observe(apod, ::renderApod)
            failure(failure, ::handleFailure)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadApod()
    }

    fun loadApod() {
        apodViewModel.loadApod()
    }

    private fun renderApod(apod: ApodView?) {
        ivCardApod.loadFromUrl(apod?.url!!)
        titleApod.setTypefaceQuickSand()
        dateApod.setTypefaceQuickSand()
        titleApod.text = apod.title
        dateApod.text = apod.date
        val preferences = AppPreferences.getPreferences()
        preferences.edit().putString("dateApod", apod.date).apply()
    }

    private fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.NetworkConnection -> toast(R.string.failure_network_connection)
            is Failure.ServerError -> toast(R.string.failure_server_error)
            is ApodFailure.ListNotAvailable -> toast(R.string.failure_movies_list_unavailable)
        }
    }


}
