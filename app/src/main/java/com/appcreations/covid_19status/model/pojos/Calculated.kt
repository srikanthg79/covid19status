package com.appcreations.covid_19status.model.pojos


import com.google.gson.annotations.SerializedName

data class Calculated(
    @SerializedName("cases_per_million_population")
    val casesPerMillionPopulation: Double,
    @SerializedName("death_rate")
    val deathRate: Double,
    @SerializedName("recovered_vs_death_ratio")
    val recoveredVsDeathRatio: Any,
    @SerializedName("recovery_rate")
    val recoveryRate: Double
)