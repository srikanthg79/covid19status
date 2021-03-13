package com.appcreations.covid_19status.model.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.appcreations.covid_19status.model.pojos.SpecificCountry
import com.appcreations.covid_19status.model.webservice.BASE_URL
import com.appcreations.covid_19status.model.webservice.Covid19RestApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CountryDetailActivityRepository(val application: Application) {

//class CountryDetailActivityRepository{

    //Application application

    /*CountryDetailActivityRepository(Application application){
        this.application = application;
     */

    private val response = MutableLiveData<SpecificCountry>()
    //MutableLiveData<SpecificCountry> response = new MutableLiveData<>();

    fun  getSpecificCountryCovid19(code:String): LiveData<SpecificCountry>{
        //LiveData<SpecificCountry> getSpecificCountryCovid19(String code){

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        /*Retrofit retrofit = new Retrofit.Builder()
             .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

         */

        val service = retrofit.create(Covid19RestApi::class.java)
        //Covid19RestApi restApi = retrofit.create(Covid19RestApi.class);

        service.getSpecificCountryCovid19(code).enqueue(object: Callback<SpecificCountry>{
            //restApi.getSpecificCountryCovid19(code).enqueue(new Callback<SpecificCountry>{

            override fun onFailure(call: Call<SpecificCountry>, t: Throwable) {

            }
            /*
            @override
            public void onFailure(Call<SpecificCountry> call, Throwable t) {

            }
             */

            override fun onResponse(call: Call<SpecificCountry>, resp: Response<SpecificCountry>) {
                response.value = resp.body()
            }
            /*@override
              onResponse(Call<SpecificCountry> call, Response<SpecificCountry> resp) {

                response.value = resp.body()
            }*/
        })

        return response
        //return response;
    }

}