package com.appcreations.covid_19status.model.pojos


import com.google.gson.annotations.SerializedName

data class Covid19Total(
    @SerializedName("_cacheHit")
    val cacheHit: Boolean,
    @SerializedName("data")
    val `data`: List<Data>
)