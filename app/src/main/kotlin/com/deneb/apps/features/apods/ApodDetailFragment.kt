package com.deneb.apps.features.apods

import android.os.Bundle
import com.deneb.apps.R
import com.deneb.apps.core.platform.BaseFragment

class ApodDetailFragment : BaseFragment() {

    companion object {
        private const val PARAM_APOD = "param_apod"

        fun forApod(apod: ApodView): ApodDetailFragment {
            val apodDetailsFragment = ApodDetailFragment()
            val arguments = Bundle()
            arguments.putParcelable(PARAM_APOD, apod)
            apodDetailsFragment.arguments = arguments

            return apodDetailsFragment
        }
    }

    override fun layoutId(): Int = R.layout.fragment_apod_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)


    }

}
