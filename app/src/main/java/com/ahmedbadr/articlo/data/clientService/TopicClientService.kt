package com.ahmedbadr.articlo.data.clientService

import com.ahmedbadr.articlo.app.constants.API
import com.ahmedbadr.articlo.data.model.response.CountryResponse
import com.ahmedbadr.articlo.data.model.response.TopicResponse
import retrofit2.Response
import retrofit2.http.GET

interface TopicClientService {
    @GET(API.LIST_TOPICS)
    suspend fun listTopics() : Response<List<TopicResponse>>
}