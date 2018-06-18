package com.deneb.apps.core.navigation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.deneb.apps.AndroidApplication
import com.deneb.apps.R
import com.deneb.apps.core.di.ApplicationComponent
import com.deneb.apps.features.apods.ApodsListFragment
import org.jetbrains.anko.find


class BottomNavActivity : AppCompatActivity() {

    private val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (application as AndroidApplication).appComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)
        appComponent.inject(this)

        val bottombar = find<BottomNavigationBar>(R.id.bottomBar)

        bottombar
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setActiveColor(R.color.black)
                .addItem(BottomNavigationItem(R.drawable.ic_home_black_24dp,"Home"))
                .addItem(BottomNavigationItem(R.drawable.ic_star_black_24dp,"Favs"))
                .initialise()

        showListApods()

        bottombar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {

            override fun onTabSelected(position: Int) {
                when(position){
                    0 -> {
                        showListApods()
                    }
                    1 -> {
                        showFavorites()
                    }
                    else -> {}
                }
            }
            override fun onTabReselected(position: Int) {}
            override fun onTabUnselected(position: Int) {}
        })
    }



    fun showListApods(){
        supportFragmentManager.beginTransaction().replace(R.id.container, ApodsListFragment()).commit()
    }
    fun showFavorites(){
        //supportFragmentManager.beginTransaction().replace(R.id.container, ApodsFavorites()).commit()
    }

}
