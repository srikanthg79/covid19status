package com.appcreations.covid_19status.view

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.appcreations.covid_19status.R
import com.appcreations.covid_19status.R.color
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(this)

        val darkMode = sharedPreferences.getBoolean("darkMode", false)

        if (darkMode) {
            navigation_view.setBackgroundColor(ContextCompat.getColor(this, color.black))
            mainActivity.setBackgroundColor(ContextCompat.getColor(this, color.black))
            bottom_navigation_view.setBackgroundColor(ContextCompat.getColor(this, color.black))
            toolbar.setBackgroundColor(ContextCompat.getColor(this, color.black))
        } else {
            navigation_view.setBackgroundColor(ContextCompat.getColor(this, color.colorPrimary))
            mainActivity.setBackgroundColor(ContextCompat.getColor(this, color.colorPrimary))
            bottom_navigation_view.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    color.colorPrimary
                )
            )
            toolbar.setBackgroundColor(ContextCompat.getColor(this, color.colorPrimaryDark))
        }


        //Setup Navigation controller
        val navController = findNavController(R.id.nav_host_fragment)

        //Set toolbar as ActionBar
        setSupportActionBar(toolbar)

        //Hookup toolbar with Navigation and DrawerLayout
        val appBarConfiguration =
            AppBarConfiguration(setOf(R.id.settings, R.id.statistics), drawer_layout)
        findViewById<Toolbar>(R.id.toolbar)
            .setupWithNavController(navController, appBarConfiguration)

        //Hookup DrawerLayout NavigationView with Navigation
        findViewById<NavigationView>(R.id.navigation_view)
            .setupWithNavController(navController)

        //Hookup BottomNavigationView with Navigation
        findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
            .setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.about -> startActivity(Intent(this, AboutActivity::class.java))
        }
        return true
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {

        var darkMode = sharedPreferences?.getBoolean("darkMode", false)

        if (darkMode!!) {
            navigation_view.setBackgroundColor(ContextCompat.getColor(this, color.black))
            mainActivity.setBackgroundColor(ContextCompat.getColor(this, color.black))
            bottom_navigation_view.setBackgroundColor(ContextCompat.getColor(this, color.black))
            toolbar.setBackgroundColor(ContextCompat.getColor(this, color.black))
        } else {
            navigation_view.setBackgroundColor(ContextCompat.getColor(this, color.colorPrimary))
            mainActivity.setBackgroundColor(ContextCompat.getColor(this, color.colorPrimary))
            bottom_navigation_view.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    color.colorPrimary
                )
            )
            toolbar.setBackgroundColor(ContextCompat.getColor(this, color.colorPrimaryDark))
        }

    }

    override fun onStart() {
        super.onStart()

        PreferenceManager.getDefaultSharedPreferences(this)
            .registerOnSharedPreferenceChangeListener(this)
    }

    override fun onStop() {
        super.onStop()

        PreferenceManager.getDefaultSharedPreferences(this)
            .unregisterOnSharedPreferenceChangeListener(this)

    }

}
