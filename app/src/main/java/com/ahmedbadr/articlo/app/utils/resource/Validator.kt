package com.ahmedbadr.articlo.app.utils.resource

enum class InValidation {
    INVALID_EMAIL,
    EMPTY_EMAIL,
    EMPTY_PASSWORD,
}

sealed class Validator(
    val validation: InValidation? = null
) {
    object Valid : Validator()
    class InValid(validation: InValidation) : Validator(validation = validation)
}
