package com.ahmedbadr.articlo.domain.repository

import com.ahmedbadr.articlo.app.utils.resource.NetworkResource
import com.ahmedbadr.articlo.data.model.request.LoginRequest
import com.ahmedbadr.articlo.data.model.request.RegistrationRequest
import com.ahmedbadr.articlo.data.model.response.TokenResponse
import com.ahmedbadr.articlo.data.model.response.UserResponse

interface AuthenticationRepository {
    suspend fun login(loginRequest: LoginRequest) : NetworkResource<TokenResponse>
    suspend fun registerUserAccount(registrationRequest: RegistrationRequest) : NetworkResource<UserResponse>
}