package com.ahmedbadr.articlo.data.model.entities.article

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ahmedbadr.articlo.app.constants.DB

@Entity(tableName = DB.ARTICLE_TABLE)
data class ArticleEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val body: String,
    val image: String,
    val publishDate: String,
    val updateDate: String,
)