package com.ahmedbadr.articlo.data.repository.topic

import com.ahmedbadr.articlo.app.utils.resource.NetworkResource
import com.ahmedbadr.articlo.data.mappers.asEntity
import com.ahmedbadr.articlo.data.model.entities.topic.TopicEntity
import com.ahmedbadr.articlo.data.model.response.TopicResponse
import com.ahmedbadr.articlo.data.source.local.topic.TopicLocalDataSource
import com.ahmedbadr.articlo.data.source.remote.topic.TopicRemoteDataSource
import com.ahmedbadr.articlo.domain.repository.TopicRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class TopicRepositoryImpl(
    private val topicLocalDataSource: TopicLocalDataSource,
    private val topicRemoteDataSource: TopicRemoteDataSource
) : TopicRepository {
    override val topicsFlow: Flow<List<TopicEntity>>
        get() = topicLocalDataSource.listTopicsFlowFromLocal().flowOn(Dispatchers.IO)

    override suspend fun listTopicsFormRemoteToLocal() {
        withContext(Dispatchers.IO) {
            val networkResource = topicRemoteDataSource.listTopicsFromRemote()
            if (networkResource is NetworkResource.Success) {
                val topicsEntity: List<TopicEntity> =
                    networkResource.data.map(TopicResponse::asEntity)
                topicLocalDataSource.insertTopicsToLocal(topicsEntity)
            }
        }
    }

    override suspend fun listTopicsFormLocal(): List<TopicEntity> {
        return withContext(Dispatchers.IO) {
            topicLocalDataSource.listTopicsFromLocal()
        }
    }
}