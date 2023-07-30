package com.ahmedbadr.articlo.data.source.local.topic

import com.ahmedbadr.articlo.data.model.entities.topic.TopicEntity
import kotlinx.coroutines.flow.Flow

interface TopicLocalDataSource {
    suspend fun insertTopicToLocal(topicEntity: TopicEntity)
    suspend fun insertTopicsToLocal(topics: List<TopicEntity>)
    suspend fun listTopicsFromLocal() : List<TopicEntity>
    fun listTopicsFlowFromLocal() : Flow<List<TopicEntity>>
}