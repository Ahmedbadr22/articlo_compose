package com.ahmedbadr.articlo.domain.usecase.authentication

import com.ahmedbadr.articlo.R
import com.ahmedbadr.articlo.app.constants.App
import com.ahmedbadr.articlo.app.utils.SharedPreferencesHelper
import com.ahmedbadr.articlo.app.utils.resource.NetworkResource
import com.ahmedbadr.articlo.app.utils.resource.Resource
import com.ahmedbadr.articlo.app.utils.validators.isValidEmail
import com.ahmedbadr.articlo.data.mappers.toLoginRequest
import com.ahmedbadr.articlo.data.model.request.LoginRequest
import com.ahmedbadr.articlo.data.model.response.TokenResponse
import com.ahmedbadr.articlo.domain.model.error.LoginError
import com.ahmedbadr.articlo.domain.model.uiState.LoginUiState
import com.ahmedbadr.articlo.domain.repository.AuthenticationRepository
import com.ahmedbadr.articlo.domain.usecase.base.BaseIOUseCase


class LoginUseCase(
    private val authenticationRepository: AuthenticationRepository,
) : BaseIOUseCase<LoginUiState, Resource<TokenResponse>, LoginError> {

    override suspend fun invoke(input: LoginUiState): Resource<TokenResponse> {
        val errors: LoginError = validateInput(input)
        return if (errors.isValid) {
            val loginRequest: LoginRequest = input.toLoginRequest()
            val resource = authenticationRepository.login(loginRequest)

            return if (resource is NetworkResource.Failure) {
                handleFailMessage(resource.failureStatus)
            } else {
                val data = (resource as NetworkResource.Success).data
                Resource.Success(data)
            }
        } else {
            Resource.Error(errors)
        }
    }

    override fun validateInput(input: LoginUiState): LoginError {
        val errors = LoginError()

        if (input.email.isEmpty()) {
            errors.emailErrorsList.add(R.string.this_field_is_required)
        }

        if (!input.email.isValidEmail()) {
            errors.emailErrorsList.add(R.string.invalid_email)
        }

        if (input.password.isEmpty()) {
            errors.passwordErrorsList.add(R.string.this_field_is_required)
        }

        return errors
    }
}