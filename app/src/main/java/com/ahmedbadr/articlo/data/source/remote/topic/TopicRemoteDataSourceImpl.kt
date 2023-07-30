package com.ahmedbadr.articlo.data.source.remote.topic

import com.ahmedbadr.articlo.app.utils.network.safeApiCall
import com.ahmedbadr.articlo.app.utils.resource.NetworkResource
import com.ahmedbadr.articlo.data.clientService.TopicClientService
import com.ahmedbadr.articlo.data.model.response.TopicResponse

class TopicRemoteDataSourceImpl(
    private val topicClientService: TopicClientService
) : TopicRemoteDataSource {
    override suspend fun listTopicsFromRemote(): NetworkResource<List<TopicResponse>> = safeApiCall {
        topicClientService.listTopics()
    }
}