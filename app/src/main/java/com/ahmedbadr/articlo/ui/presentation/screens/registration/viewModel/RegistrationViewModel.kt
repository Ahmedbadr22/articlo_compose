package com.ahmedbadr.articlo.ui.presentation.screens.registration.viewModel

import android.content.res.Resources
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmedbadr.articlo.app.utils.resource.Resource
import com.ahmedbadr.articlo.domain.model.error.RegistrationError
import com.ahmedbadr.articlo.domain.model.uiState.RegistrationUiState
import com.ahmedbadr.articlo.domain.usecase.authentication.CreateUserAccountUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegistrationViewModel(
    private val createUserAccountUseCase: CreateUserAccountUseCase,
    private val appResources: Resources
) : ViewModel() {
    var uiState: MutableStateFlow<RegistrationUiState> = MutableStateFlow(RegistrationUiState())
        private set

    fun register() {
        isLoading(true)
        viewModelScope.launch {
            when (val resource = createUserAccountUseCase(uiState.value)) {
                is Resource.Success -> {
                    uiState.update { state ->
                        state.copy(isSuccessRegistration = true)
                    }
                    isLoading(false)
                }

                is Resource.Error -> {
                    val error: RegistrationError = (resource.errors as RegistrationError)
                    setRegistrationErrors(error)
                    isLoading(false)
                }

                is Resource.NetworkError -> {
                    setMainError(resource.error)
                    isLoading(false)
                }
            }
        }
    }

    private fun setMainError(@StringRes resource: Int) {
        uiState.update { state ->
            state.copy(mainError = appResources.getString(resource))
        }
    }

    private fun setRegistrationErrors(registrationError: RegistrationError) {
        uiState.update { state ->
            state.copy(errors = registrationError)
        }
    }

    private fun isLoading(loading: Boolean) {
        uiState.update { state ->
            state.copy(loading = loading)
        }
    }

    fun setUserEmail(email: String) {
        uiState.update { state ->
            state.copy(email = email)
        }
    }


    fun setUsername(username: String) {
        uiState.update { state ->
            state.copy(username = username)
        }
    }

    fun setFullName(fullName: String) {
        uiState.update { state ->
            state.copy(fullName = fullName)
        }
    }

    fun setConfirmPassword(password: String) {
        uiState.update { state ->
            state.copy(confirmPassword = password)
        }
    }

    fun setUserPassword(password: String) {
        uiState.update { state ->
            state.copy(password = password)
        }
    }

    fun setIsMale(isMale: Boolean) {
        uiState.update { state ->
            state.copy(isMale = isMale)
        }
    }
}