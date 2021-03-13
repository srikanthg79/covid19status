package com.appcreations.covid_19status.model.room

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.appcreations.covid_19status.model.pojos.Data

@Database(entities = [Data::class], version = 1)
abstract class Covid19Database : RoomDatabase() {

    abstract fun dataDao(): DataDao

    companion object {

        fun getRoom(application: Application): Covid19Database =
            Room.databaseBuilder(application, Covid19Database::class.java, "covid19_roomdB").build()
    }
}