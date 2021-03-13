package com.appcreations.covid_19status.model.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.appcreations.covid_19status.model.pojos.Covid19Countries
import com.appcreations.covid_19status.model.webservice.BASE_URL
import com.appcreations.covid_19status.model.webservice.Covid19RestApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CountryCasesFragmentRepository(application: Application) {

    private val response = MutableLiveData<Covid19Countries>()

    fun getCountriesCovid19(): LiveData<Covid19Countries>? {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(Covid19RestApi::class.java)
        service.getCountriesCovid19().enqueue(object: Callback<Covid19Countries> {
            override fun onFailure(call: Call<Covid19Countries>, t: Throwable) {
                Log.i("Country19",t.message)
            }

            override fun onResponse(call: Call<Covid19Countries>, resp: Response<Covid19Countries>) {
                response?.value = resp.body()
                Log.i("Country19_2",resp.body()!!.data.toString())
            }
        })

        return response
    }


}