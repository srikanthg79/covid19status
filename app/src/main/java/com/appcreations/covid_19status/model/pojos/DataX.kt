package com.appcreations.covid_19status.model.pojos


import com.google.gson.annotations.SerializedName

data class DataX(

    @SerializedName("code")
    val code: String,
    @SerializedName("coordinates")
    val coordinates: Coordinates,
    @SerializedName("latest_data")
    val latestData: LatestData,
    @SerializedName("name")
    val name: String,
    @SerializedName("population")
    val population: Int,
    @SerializedName("today")
    val today: Today,
    @SerializedName("updated_at")
    val updatedAt: String
)