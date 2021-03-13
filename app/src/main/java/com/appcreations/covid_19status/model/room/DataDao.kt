package com.appcreations.covid_19status.model.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.appcreations.covid_19status.model.pojos.Data

@Dao
interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCases(data: Data)

    @Query("SELECT * from cases")

    fun getTotalCases(): LiveData<Data>

}