package com.ahmedbadr.articlo.data.clientService

import com.ahmedbadr.articlo.app.constants.API
import com.ahmedbadr.articlo.data.model.request.LoginRequest
import com.ahmedbadr.articlo.data.model.request.RegistrationRequest
import com.ahmedbadr.articlo.data.model.response.TokenResponse
import com.ahmedbadr.articlo.data.model.response.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationClientService {
    @POST(API.LOGIN)
    suspend fun login(@Body loginRequest: LoginRequest) : Response<TokenResponse>

    @POST(API.CREATE_ACCOUNT)
    suspend fun registerUser(@Body registrationRequest: RegistrationRequest) : Response<UserResponse>
}