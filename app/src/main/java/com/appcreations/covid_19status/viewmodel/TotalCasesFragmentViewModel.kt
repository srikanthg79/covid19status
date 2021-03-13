package com.appcreations.covid_19status.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.appcreations.covid_19status.model.pojos.Covid19Total
import com.appcreations.covid_19status.model.pojos.Data
import com.appcreations.covid_19status.model.repository.TotalCasesFragmentRepository


class TotalCasesFragmentViewModel(application: Application) : AndroidViewModel(application) {

//class TotalCasesFragmentViewModel extends  AndroidViewModel {

    //Application application;

    /*TotalCasesFragmentViewModel(Application application){

     this.application = application;
    }
    */

    private var repository = TotalCasesFragmentRepository(application)
    //TotalCasesFragmentRepository repository = new TotalCasesFragmentRepository(application);

    fun getTotalCovid19(): LiveData<Covid19Total>? = repository.getTotalCovid19()
    /*LiveData<Covid19Total> getTotalCovid19(){
        return repository.getTotalCovid19();
    */

    fun getTotalCases(): LiveData<Data> = repository.getTotalCases()

}