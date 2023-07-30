package com.ahmedbadr.articlo.app.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ahmedbadr.articlo.app.constants.DB
import com.ahmedbadr.articlo.data.model.entities.topic.TopicEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TopicDao {
    /**
     * insert topicEntity instance of [TopicEntity] Table into [DB.TOPIC_TABLE]
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopic(topicEntity: TopicEntity)

    /**
     * insert collection of [TopicEntity] Table into [DB.TOPIC_TABLE]
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopics(topics: List<TopicEntity>)

    /**
     * @return [List] collection of [TopicEntity] Table
     */
    @Query("SELECT * FROM ${DB.TOPIC_TABLE}")
    suspend fun listTopics() : List<TopicEntity>

    /**
     * @return [Flow] List collection of [TopicEntity] Table
     */
    @Query("SELECT * FROM ${DB.TOPIC_TABLE}")
    fun listTopicsFlow() : Flow<List<TopicEntity>>

}