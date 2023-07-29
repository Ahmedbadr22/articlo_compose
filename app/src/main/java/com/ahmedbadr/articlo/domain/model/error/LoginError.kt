package com.ahmedbadr.articlo.domain.model.error

data class LoginError(
    val emailErrorsList: MutableList<Int> = mutableListOf(),
    val passwordErrorsList: MutableList<Int> = mutableListOf(),
) {
    val isValid: Boolean
        get() = emailErrorsList.isEmpty() && passwordErrorsList.isEmpty()

}
