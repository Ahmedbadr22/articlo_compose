package com.ahmedbadr.articlo.data.source.remote.authentication

import com.ahmedbadr.articlo.app.utils.resource.NetworkResource
import com.ahmedbadr.articlo.data.model.request.LoginRequest
import com.ahmedbadr.articlo.data.model.request.RegistrationRequest
import com.ahmedbadr.articlo.data.model.response.TokenResponse
import com.ahmedbadr.articlo.data.model.response.UserResponse


interface AuthenticationRemoteDatasource {
    suspend fun login(loginRequest: LoginRequest) : NetworkResource<TokenResponse>
    suspend fun registerNewAccount(registrationRequest: RegistrationRequest) : NetworkResource<UserResponse>
}