package com.ahmedbadr.articlo.domain.model.uiState

import com.ahmedbadr.articlo.domain.model.error.LoginError

data class LoginUiState(
    var email: String = "",
    var password: String = "",
    var loading: Boolean = false,
    var errors: LoginError = LoginError(),
    var mainError: String = "",
    var navigateToMainScreen: Boolean = false,
)
