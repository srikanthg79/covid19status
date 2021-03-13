package com.appcreations.covid_19status.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.appcreations.covid_19status.model.pojos.Covid19Countries
import com.appcreations.covid_19status.model.repository.CountryCasesFragmentRepository


class CountryCasesFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CountryCasesFragmentRepository(application)

    fun getCountriesCovid19(): LiveData<Covid19Countries>? = repository.getCountriesCovid19()

}