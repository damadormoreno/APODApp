package com.deneb.apps.core.navigation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.deneb.apps.R
import org.jetbrains.anko.find


class BottomNavActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)

        val bottombar = find<BottomNavigationBar>(R.id.bottomBar)

        

    }
}
