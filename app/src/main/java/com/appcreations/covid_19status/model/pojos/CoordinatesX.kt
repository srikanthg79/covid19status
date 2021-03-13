package com.appcreations.covid_19status.model.pojos


import com.google.gson.annotations.SerializedName

data class CoordinatesX(
    @SerializedName("latitude")
    val latitude: Float,
    @SerializedName("longitude")
    val longitude: Float
)