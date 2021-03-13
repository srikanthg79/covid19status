package com.appcreations.covid_19status.model.pojos


import com.google.gson.annotations.SerializedName

data class TodayX(
    @SerializedName("confirmed")
    val confirmed: Int,
    @SerializedName("deaths")
    val deaths: Int
)