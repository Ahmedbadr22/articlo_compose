package com.ahmedbadr.articlo.domain.usecase.authentication

import com.ahmedbadr.articlo.R
import com.ahmedbadr.articlo.app.utils.resource.NetworkResource
import com.ahmedbadr.articlo.app.utils.resource.Resource
import com.ahmedbadr.articlo.app.utils.validators.isValidEmail
import com.ahmedbadr.articlo.data.mappers.toRegistrationRequest
import com.ahmedbadr.articlo.data.model.response.UserResponse
import com.ahmedbadr.articlo.domain.model.error.RegistrationError
import com.ahmedbadr.articlo.domain.model.uiState.RegistrationUiState
import com.ahmedbadr.articlo.domain.repository.AuthenticationRepository
import com.ahmedbadr.articlo.domain.usecase.base.BaseIOUseCase


class CreateUserAccountUseCase(
    private val authenticationRepository: AuthenticationRepository
) : BaseIOUseCase<RegistrationUiState, Resource<UserResponse>, RegistrationError> {
    override suspend fun invoke(input: RegistrationUiState): Resource<UserResponse> {
        val registrationError = validateInput(input)
        return if (registrationError.isValid) {
            val networkResource = authenticationRepository.registerUserAccount(input.toRegistrationRequest())
            return if (networkResource is NetworkResource.Success) {
                Resource.Success(networkResource.data)
            } else {
                val error = (networkResource as NetworkResource.Failure).failureStatus
                handleFailMessage(error)
            }
        } else {
            Resource.Error(registrationError)
        }
    }

    override fun validateInput(input: RegistrationUiState): RegistrationError {
        val registrationError = RegistrationError()
        if (input.email.isEmpty()) {
            registrationError.emailErrorsList.add(R.string.this_field_is_required)
        }

        if (!input.email.isValidEmail()) {
            registrationError.emailErrorsList.add(R.string.invalid_email)
        }

        if (input.password.isEmpty()) {
            registrationError.passwordErrorsList.add(R.string.this_field_is_required)
        }

        if (input.confirmPassword.isEmpty()) {
            registrationError.confirmPasswordErrorsList.add(R.string.this_field_is_required)
        }

        if (input.password == input.confirmPassword) {
            registrationError.confirmPasswordErrorsList.add(R.string.password_should_be_same)
        }

        if (input.fullName.isEmpty()) {
            registrationError.fullNameErrorsList.add(R.string.this_field_is_required)
        }

        if (input.username.isEmpty()) {
            registrationError.usernameErrorsList.add(R.string.this_field_is_required)
        }

        return registrationError
    }
}