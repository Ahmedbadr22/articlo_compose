package com.ahmedbadr.articlo.domain.usecase.topic

import com.ahmedbadr.articlo.domain.repository.TopicRepository
import com.ahmedbadr.articlo.domain.usecase.base.BaseUseCase

class ListTopicsFromRemoteToLocalUseCase(
    private val topicRepository: TopicRepository
) : BaseUseCase {
    override suspend fun invoke() {
        topicRepository.listTopicsFormRemoteToLocal()
    }
}