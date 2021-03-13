package com.appcreations.covid_19status.model.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.appcreations.covid_19status.model.pojos.Covid19Total
import com.appcreations.covid_19status.model.pojos.Data
import com.appcreations.covid_19status.model.room.Covid19Database
import com.appcreations.covid_19status.model.webservice.BASE_URL
import com.appcreations.covid_19status.model.webservice.Covid19RestApi
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.concurrent.thread

class TotalCasesFragmentRepository(application: Application){

//class TotalCasesFragmentRepository {

    //public static final BASE_URL = "https://corona-api.com";

    //Application application;

    /*TotalCasesFragmentRepository(Application application){
        this.application = application;

    }*/

    private val response = MutableLiveData<Covid19Total>()
    //MutableLiveData<Covid19Total> response = new MutableLiveData<>(); This is the java version


    private val roomDb = Covid19Database.getRoom(application)

    fun getTotalCases(): LiveData<Data> = roomDb.dataDao().getTotalCases()

    fun getTotalCovid19(): LiveData<Covid19Total> {

        //public LiveData<Covid19Total> getTotalCovid19() {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        /* Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
         */

        /*Covid19RestApi restApi = retrofit.create(Covid19RestApi.class);

        Call<Covid19Total> call = restApi.getTotalCovid19();

        call.enqueue(new Callback<Covid19Total>(){
              @override
              public void onFailure(Call<Covid19Total> call, Throwable t) {
                Log.i("Covid19",t.message)
              }

              @override
              public void onResponse(Call<Covid19Total> call, Response<Covid19Total> resp) {
                   response = resp.body();
              }
        })*/

        val service = retrofit.create(Covid19RestApi::class.java) //if java just fill Covid19RestApi.class
        service.getTotalCovid19().enqueue(object: Callback<Covid19Total>{
            override fun onFailure(call: Call<Covid19Total>, t: Throwable) {
                Log.i("Covid19",t.message)
            }

            override fun onResponse(call: Call<Covid19Total>, resp: Response<Covid19Total>) {
                response.value = resp.body()
                thread(start = true) {roomDb.dataDao().insertCases(resp.body()!!.data[0])  }

            }
        })
        return response
        //return response;
    }
}