package com.appcreations.covid_19status.model.pojos


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "cases")
data class Data(

    @PrimaryKey
    val id: Int = 0,
    @SerializedName("active")
    val active: Int = 0,
    @SerializedName("confirmed")
    val confirmed: Int = 0,
    @SerializedName("date")
    val date: String = "",
    @SerializedName("deaths")
    val deaths: Int = 0,
    @SerializedName("is_in_progress")
    val isInProgress: Boolean = false,
    @SerializedName("new_confirmed")
    val newConfirmed: Int = 0,
    @SerializedName("new_deaths")
    val newDeaths: Int = 0,
    @SerializedName("new_recovered")
    val newRecovered: Int = 0,
    @SerializedName("recovered")
    val recovered: Int = 0,

    @SerializedName("updated_at")
    @ColumnInfo(name="last_updated")
    val updatedAt: String = ""
)