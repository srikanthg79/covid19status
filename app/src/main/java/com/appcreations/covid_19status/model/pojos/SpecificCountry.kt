package com.appcreations.covid_19status.model.pojos

import com.google.gson.annotations.SerializedName

data class SpecificCountry(

    @SerializedName("_cacheHit")
    val cacheHit: Boolean,
    @SerializedName("data")
    val `data`: DataXX

)