package com.appcreations.covid_19status.model.webservice


import com.appcreations.covid_19status.model.pojos.Covid19Countries
import com.appcreations.covid_19status.model.pojos.Covid19Total
import com.appcreations.covid_19status.model.pojos.SpecificCountry
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

val BASE_URL = "https://corona-api.com"
// public static final String BASE_URL = "https://corona-api.com";

interface Covid19RestApi {

    @GET("/timeline")
    fun getTotalCovid19(): Call<Covid19Total>
    //Call<Covid19Total> getTotalCovid19(); This is java version

    @GET("/countries")
    fun getCountriesCovid19(): Call<Covid19Countries>
    //Call<Covid19Countries> getCountriesCovid19();


    @GET("/countries/{code}")
    fun getSpecificCountryCovid19(@Path("code")code:String) : Call<SpecificCountry>
    //Call<SpecificCountry> getSpecificCountryCovid19(@Path("code")String code)

}