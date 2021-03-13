package com.appcreations.covid_19status.model.pojos


import com.google.gson.annotations.SerializedName

data class LatestData(
    @SerializedName("calculated")
    val calculated: Calculated,
    @SerializedName("confirmed")
    val confirmed: Int,
    @SerializedName("critical")
    val critical: Int,
    @SerializedName("deaths")
    val deaths: Int,
    @SerializedName("recovered")
    val recovered: Int
)