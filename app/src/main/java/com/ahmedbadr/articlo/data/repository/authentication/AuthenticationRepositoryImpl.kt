package com.ahmedbadr.articlo.data.repository.authentication

import com.ahmedbadr.articlo.app.utils.resource.NetworkResource
import com.ahmedbadr.articlo.data.model.request.LoginRequest
import com.ahmedbadr.articlo.data.model.request.RegistrationRequest
import com.ahmedbadr.articlo.data.model.response.TokenResponse
import com.ahmedbadr.articlo.data.model.response.UserResponse
import com.ahmedbadr.articlo.data.source.remote.authentication.AuthenticationRemoteDatasource
import com.ahmedbadr.articlo.domain.repository.AuthenticationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthenticationRepositoryImpl(
    private val authenticationRemoteDatasource: AuthenticationRemoteDatasource
) : AuthenticationRepository {

    override suspend fun login(loginRequest: LoginRequest): NetworkResource<TokenResponse> {
        return withContext(Dispatchers.IO) {
            authenticationRemoteDatasource.login(loginRequest)
        }
    }

    override suspend fun registerUserAccount(registrationRequest: RegistrationRequest): NetworkResource<UserResponse> {
        return withContext(Dispatchers.IO) {
            authenticationRemoteDatasource.registerNewAccount(registrationRequest)
        }
    }

}