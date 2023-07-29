package com.ahmedbadr.articlo.domain.model.uiState

import com.ahmedbadr.articlo.domain.model.error.LoginError
import com.ahmedbadr.articlo.domain.model.error.RegistrationError

data class RegistrationUiState(
    var email: String = "",
    var fullName: String = "",
    var username: String = "",
    var password: String = "",
    var confirmPassword: String = "",
    var countryId: Int = 0 ,
    var isMale: Boolean = true,
    var loading: Boolean = false,
    var isSuccessRegistration: Boolean = false,
    var errors: RegistrationError = RegistrationError(),
    var mainError: String = "",
)
