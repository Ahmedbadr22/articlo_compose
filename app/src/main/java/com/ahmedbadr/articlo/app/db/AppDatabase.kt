package com.ahmedbadr.articlo.app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ahmedbadr.articlo.app.db.dao.CountryDao
import com.ahmedbadr.articlo.data.model.entities.CountryEntity

@Database(
    entities = [
        CountryEntity::class
    ],
    version = 1,
    exportSchema = false,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getCountryDao() : CountryDao

}