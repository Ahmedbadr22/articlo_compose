package com.ahmedbadr.articlo.data.source.remote.authentication

import com.ahmedbadr.articlo.app.utils.network.safeApiCall
import com.ahmedbadr.articlo.app.utils.resource.NetworkResource
import com.ahmedbadr.articlo.data.clientService.AuthenticationClientService
import com.ahmedbadr.articlo.data.model.request.LoginRequest
import com.ahmedbadr.articlo.data.model.request.RegistrationRequest
import com.ahmedbadr.articlo.data.model.response.TokenResponse
import com.ahmedbadr.articlo.data.model.response.UserResponse

class AuthenticationRemoteDatasourceImpl(
    private val authenticationClientService: AuthenticationClientService,
) : AuthenticationRemoteDatasource {
    override suspend fun login(loginRequest: LoginRequest): NetworkResource<TokenResponse> = safeApiCall {
        authenticationClientService.login(loginRequest)
    }

    override suspend fun registerNewAccount(registrationRequest: RegistrationRequest): NetworkResource<UserResponse> = safeApiCall {
        authenticationClientService.registerUser(registrationRequest)
    }
}