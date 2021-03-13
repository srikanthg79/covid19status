package com.appcreations.covid_19status.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.appcreations.covid_19status.model.pojos.SpecificCountry
import com.appcreations.covid_19status.model.repository.CountryDetailActivityRepository

class CountryDetailActivityViewModel(application: Application) : AndroidViewModel(application) {
    //class CountryDetailActivityViewModel extends AndroidViewModel {

    //Application application;

    /*CountryDetailActivityViewModel(Application application){
        this.application = application;
    }
     */

    private val repository = CountryDetailActivityRepository(application)
    //private CountryDetailActivityRepository repository = new CountryDetailActivityRepository(application);

    fun getSpecificCountryCovid19(code:String): LiveData<SpecificCountry> = repository.getSpecificCountryCovid19(code)
    /*
    LiveData<SpecificCountry> getSpecificCountryCovid19(String code){
    return repository.getSpecificCountryCovid19(code);
    }
     */

}