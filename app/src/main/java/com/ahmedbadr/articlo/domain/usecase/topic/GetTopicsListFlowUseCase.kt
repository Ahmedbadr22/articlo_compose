package com.ahmedbadr.articlo.domain.usecase.topic

import com.ahmedbadr.articlo.data.mappers.asTopic
import com.ahmedbadr.articlo.data.model.entities.topic.TopicEntity
import com.ahmedbadr.articlo.domain.model.data.Topic
import com.ahmedbadr.articlo.domain.repository.TopicRepository
import com.ahmedbadr.articlo.domain.usecase.base.BaseOUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class GetTopicsListFlowUseCase(
    private val topicRepository: TopicRepository
) : BaseOUseCase<Flow<List<Topic>>> {
    override suspend fun invoke(): Flow<List<Topic>> {
        return topicRepository.topicsFlow.map { topicsEntity ->
            topicsEntity.map(TopicEntity::asTopic)
        }.flowOn(Dispatchers.Main)
    }
}