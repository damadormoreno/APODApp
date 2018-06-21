package com.deneb.apps.features.apods

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import com.deneb.apps.R
import com.deneb.apps.core.exception.Failure
import com.deneb.apps.core.extension.*
import com.deneb.apps.core.navigation.BottomNavActivity
import com.deneb.apps.core.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_apods_list.*
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

class ApodsListFragment : BaseFragment() {


    @Inject lateinit var apodAdapter: ApodsAdapter

    private lateinit var apodsListViewModel: ApodsListViewModel

    override fun layoutId(): Int = R.layout.fragment_apods_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        apodsListViewModel = viewModel(viewModelFactory) {
            observe(apods, ::renderApodsList)
            failure(failure, ::handleFailure)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        loadApodsList()
    }

    private fun initializeView() {
        rvApods.layoutManager = LinearLayoutManager(activity)
        rvApods.adapter = apodAdapter

    }

    private fun loadApodsList() {
        progress.visibility = View.VISIBLE
        apodsListViewModel.loadApods()
    }

    private fun renderApodsList(apods: List<ApodView>?) {
        apodAdapter.collection = apods.orEmpty()
        progress.visibility = View.GONE
    }

    private fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.NetworkConnection -> toast(R.string.failure_network_connection)
            is Failure.ServerError -> toast(R.string.failure_server_error)
            is ApodFailure.ListNotAvailable -> toast(R.string.failure_movies_list_unavailable)
        }
    }
}
