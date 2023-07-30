package com.ahmedbadr.articlo.data.mappers

import com.ahmedbadr.articlo.data.model.entities.topic.TopicEntity
import com.ahmedbadr.articlo.data.model.response.TopicResponse
import com.ahmedbadr.articlo.domain.model.data.Topic


fun TopicResponse.asEntity() = TopicEntity(id, name, image, articleCount)
fun TopicEntity.asData() = Topic(id, name, image, articleCount)