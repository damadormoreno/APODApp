package com.deneb.apps.features.apods

import android.content.Context
import android.content.Intent
import com.deneb.apps.core.platform.BaseActivity

class ApodDetailActivity : BaseActivity() {

    companion object {
        private const val INTENT_EXTRA_PARAM_APOD = "com.deneb.apps.INTENT_PARAM_APOD"

        fun callingIntent(context: Context, apodView: ApodView) : Intent {
            val intent = Intent(context, ApodDetailActivity::class.java)
            intent.putExtra(INTENT_EXTRA_PARAM_APOD, apodView)
            return intent
        }
    }

    override fun fragment() = ApodDetailFragment.forApod(intent.getParcelableExtra(INTENT_EXTRA_PARAM_APOD))
}
