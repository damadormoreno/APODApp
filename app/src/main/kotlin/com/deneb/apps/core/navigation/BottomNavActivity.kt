package com.deneb.apps.core.navigation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.deneb.apps.AndroidApplication
import com.deneb.apps.R
import com.deneb.apps.core.di.ApplicationComponent
import com.deneb.apps.features.apods.ApodFragment
import com.deneb.apps.features.apods.ApodsListFragment
import org.jetbrains.anko.find
import com.deneb.apps.core.extension.setTypefaceQuickSandBold
import kotlinx.android.synthetic.main.activity_bottom_nav.*


class BottomNavActivity : AppCompatActivity() {

    private val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (application as AndroidApplication).appComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)
        appComponent.inject(this)

        val bottombar = find<BottomNavigationBar>(R.id.bottomBar)

        toolbarTitle.setTypefaceQuickSandBold()

        bottombar
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setActiveColor(R.color.black)
                .addItem(BottomNavigationItem(R.drawable.ic_home_black_24dp,"APOD"))
                .addItem(BottomNavigationItem(R.drawable.ic_list_black_24dp,"Lista"))
                .addItem(BottomNavigationItem(R.drawable.ic_favorite_black_24dp,"Favoritos"))
                .initialise()

        showApod()

        bottombar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {

            override fun onTabSelected(position: Int) {
                when(position){
                    0 -> { showApod() }
                    1 -> { showListApods() }
                    2 -> { showFavorites() }
                    else -> {}
                }
            }
            override fun onTabReselected(position: Int) {}
            override fun onTabUnselected(position: Int) {}
        })
    }

    fun showApod(){
        supportFragmentManager.beginTransaction().replace(R.id.container, ApodFragment() , "apod").commit()
    }
    fun showListApods(){
        supportFragmentManager.beginTransaction().replace(R.id.container, ApodsListFragment(), "list").commit()
    }
    fun showFavorites(){
        //supportFragmentManager.beginTransaction().replace(R.id.container, ApodsFavorites()).commit()
    }
}
