package com.ahmedbadr.articlo.app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ahmedbadr.articlo.app.db.dao.CountryDao
import com.ahmedbadr.articlo.app.db.dao.TopicDao
import com.ahmedbadr.articlo.data.model.entities.CountryEntity
import com.ahmedbadr.articlo.data.model.entities.topic.TopicEntity

@Database(
    entities = [
        CountryEntity::class,
        TopicEntity::class
    ],
    version = 2,
    exportSchema = false,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getCountryDao() : CountryDao
    abstract fun getTopicDao() : TopicDao

}