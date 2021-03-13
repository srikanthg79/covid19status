package com.appcreations.covid_19status.model.pojos


import com.google.gson.annotations.SerializedName

data class DataXX(
    @SerializedName("code")
    val code: String,
    @SerializedName("coordinates")
    val coordinates: CoordinatesX,
    @SerializedName("latest_data")
    val latestData: LatestDataX,
    @SerializedName("name")
    val name: String,
    @SerializedName("population")
    val population: Int,
    @SerializedName("timeline")
    val timeline: List<Timeline>,
    @SerializedName("today")
    val today: TodayX,
    @SerializedName("updated_at")
    val updatedAt: String
)