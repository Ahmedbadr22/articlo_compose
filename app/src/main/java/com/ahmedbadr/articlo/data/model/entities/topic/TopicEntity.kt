package com.ahmedbadr.articlo.data.model.entities.topic

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ahmedbadr.articlo.app.constants.DB

@Entity(tableName = DB.TOPIC_TABLE)
data class TopicEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val image: String,
    val articleCount: Int,
)