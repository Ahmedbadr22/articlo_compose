package com.ahmedbadr.articlo.data.model.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    val id: Int,
    val email: String,
    val username: String,
    @SerializedName("fullname")
    val fullName: String,
    @SerializedName("is_name")
    val isMale: Boolean,
)
