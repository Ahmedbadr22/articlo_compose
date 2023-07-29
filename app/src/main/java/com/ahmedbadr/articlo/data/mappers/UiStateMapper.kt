package com.ahmedbadr.articlo.data.mappers

import com.ahmedbadr.articlo.data.model.request.LoginRequest
import com.ahmedbadr.articlo.data.model.request.RegistrationRequest
import com.ahmedbadr.articlo.domain.model.uiState.LoginUiState
import com.ahmedbadr.articlo.domain.model.uiState.RegistrationUiState


fun LoginUiState.toLoginRequest() = LoginRequest(email, password)
fun RegistrationUiState.toRegistrationRequest() = RegistrationRequest(
    email = email,
    password = password,
    fullName = fullName,
    username = username,
    isMale = isMale,
    countryId = countryId
)