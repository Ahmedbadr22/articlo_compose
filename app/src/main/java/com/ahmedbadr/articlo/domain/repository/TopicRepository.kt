package com.ahmedbadr.articlo.domain.repository

import com.ahmedbadr.articlo.data.model.entities.topic.TopicEntity
import kotlinx.coroutines.flow.Flow

interface TopicRepository {
    val topicsFlow: Flow<List<TopicEntity>>

    suspend fun listTopicsFormRemoteToLocal()
    suspend fun listTopicsFormLocal() : List<TopicEntity>
}