package com.ahmedbadr.articlo.domain.usecase.topic

import com.ahmedbadr.articlo.data.mappers.asTopic
import com.ahmedbadr.articlo.data.model.entities.topic.TopicEntity
import com.ahmedbadr.articlo.domain.model.data.Topic
import com.ahmedbadr.articlo.domain.repository.TopicRepository
import com.ahmedbadr.articlo.domain.usecase.base.BaseOUseCase

class ListTopicsFromLocalUseCase(
    private val topicRepository: TopicRepository
) : BaseOUseCase<List<Topic>> {
    override suspend fun invoke(): List<Topic> {
        return topicRepository.listTopicsFormLocal().map(TopicEntity::asTopic)
    }
}