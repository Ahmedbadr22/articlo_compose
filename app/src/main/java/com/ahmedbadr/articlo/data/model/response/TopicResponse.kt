package com.ahmedbadr.articlo.data.model.response

import com.google.gson.annotations.SerializedName

data class TopicResponse(
    val id: Int,
    val name: String,
    val image: String,
    @SerializedName("article_count")
    val articleCount: Int,
)