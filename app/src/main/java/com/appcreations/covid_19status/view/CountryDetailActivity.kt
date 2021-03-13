package com.appcreations.covid_19status.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import com.appcreations.covid_19status.R
import com.appcreations.covid_19status.viewmodel.CountryDetailActivityViewModel
import kotlinx.android.synthetic.main.activity_country_detail.*

class CountryDetailActivity : AppCompatActivity() {

    //CountryDetailActivityViewModel viewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_detail)

        setSupportActionBar(countryDetailToolbar)

        val countryCode = intent.getStringExtra("country_code")

        val viewModel = ViewModelProvider(this).get(CountryDetailActivityViewModel::class.java)
        //viewModel = ViewModelProviders(this).get(CountryDetailActivityViewModel.class);

        viewModel.getSpecificCountryCovid19(countryCode).observe(this, Observer {

            if (it != null) {
                countryDetailProgressBar.visibility = View.GONE
                countrySpecific.text = it.data.name
                if(!it.data.timeline.isNullOrEmpty()){
                    date.text = it.data.timeline[0].date
                }
                populationValue.text = it.data.population.toString()
                countryTodayConfirmedValue.text = it.data.today.confirmed.toString()
                countryTodayDeathValue.text = it.data.today.deaths.toString()
                totalCountryConfirmedValue.text = it.data.latestData.confirmed.toString()
                totalCountryRecoveredValue.text = it.data.latestData.recovered.toString()
                totalCountryDeathsValue.text = it.data.latestData.deaths.toString()
            }

        })

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        val darkMode = sharedPreferences.getBoolean("darkMode", false)

        if (darkMode) {
            countryDetailConstraintLayout.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.black
                )
            )
            countryDetailToolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        } else {
            countryDetailConstraintLayout.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.colorPrimary
                )
            )
            countryDetailToolbar.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.colorPrimaryDark
                )
            )
        }
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

}
