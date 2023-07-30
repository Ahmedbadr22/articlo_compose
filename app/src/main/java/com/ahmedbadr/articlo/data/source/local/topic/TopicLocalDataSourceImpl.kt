package com.ahmedbadr.articlo.data.source.local.topic

import com.ahmedbadr.articlo.app.db.dao.TopicDao
import com.ahmedbadr.articlo.data.model.entities.topic.TopicEntity
import kotlinx.coroutines.flow.Flow

class TopicLocalDataSourceImpl(
    private val topicDao: TopicDao
) : TopicLocalDataSource{
    override suspend fun insertTopicToLocal(topicEntity: TopicEntity) {
        topicDao.insertTopic(topicEntity)
    }

    override suspend fun insertTopicsToLocal(topics: List<TopicEntity>) {
        topicDao.insertTopics(topics)
    }

    override suspend fun listTopicsFromLocal(): List<TopicEntity> {
        return topicDao.listTopics()
    }

    override fun listTopicsFlowFromLocal(): Flow<List<TopicEntity>> {
        return topicDao.listTopicsFlow()
    }
}