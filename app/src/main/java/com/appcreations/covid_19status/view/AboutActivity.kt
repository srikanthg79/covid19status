package com.appcreations.covid_19status.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.preference.PreferenceManager
import com.appcreations.covid_19status.R
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        setSupportActionBar(aboutToolbar)

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        val darkMode = sharedPreferences.getBoolean("darkMode",false)

        if(darkMode){
            aboutActivity.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
            aboutToolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        }else{
            aboutActivity.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary))
            aboutToolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))
        }

    }


}
