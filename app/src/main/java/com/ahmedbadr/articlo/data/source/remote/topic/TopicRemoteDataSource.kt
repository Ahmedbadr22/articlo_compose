package com.ahmedbadr.articlo.data.source.remote.topic

import com.ahmedbadr.articlo.app.utils.resource.NetworkResource
import com.ahmedbadr.articlo.data.model.response.TopicResponse

interface TopicRemoteDataSource {
   suspend fun listTopicsFromRemote() : NetworkResource<List<TopicResponse>>
}