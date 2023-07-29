package com.ahmedbadr.articlo.domain.model.error

data class RegistrationError(
    val emailErrorsList: MutableList<Int> = mutableListOf(),
    val passwordErrorsList: MutableList<Int> = mutableListOf(),
    val confirmPasswordErrorsList: MutableList<Int> = mutableListOf(),
    val fullNameErrorsList: MutableList<Int> = mutableListOf(),
    val usernameErrorsList: MutableList<Int> = mutableListOf(),
) {
    val isValid: Boolean
        get() = emailErrorsList.isEmpty() && passwordErrorsList.isEmpty() && confirmPasswordErrorsList.isEmpty() && fullNameErrorsList.isEmpty() && usernameErrorsList.isEmpty()

}
