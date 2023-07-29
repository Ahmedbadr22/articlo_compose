package com.ahmedbadr.articlo.data.model.request

import com.google.gson.annotations.SerializedName

data class RegistrationRequest(
    val email: String,
    val password: String,
    @SerializedName("fullname")
    val fullName: String,
    val username: String,
    @SerializedName("is_male")
    val isMale: Boolean,
    @SerializedName("country")
    val countryId: Int,
)

