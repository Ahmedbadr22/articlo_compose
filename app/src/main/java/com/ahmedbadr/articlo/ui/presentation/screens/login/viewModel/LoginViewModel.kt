package com.ahmedbadr.articlo.ui.presentation.screens.login.viewModel

import android.content.res.Resources
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmedbadr.articlo.app.utils.resource.Resource
import com.ahmedbadr.articlo.data.model.response.TokenResponse
import com.ahmedbadr.articlo.domain.model.error.LoginError
import com.ahmedbadr.articlo.domain.model.uiState.LoginUiState
import com.ahmedbadr.articlo.domain.usecase.user.GetIsAuthenticatedUseCase
import com.ahmedbadr.articlo.domain.usecase.authentication.LoginUseCase
import com.ahmedbadr.articlo.domain.usecase.user.SaveAccessTokenUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val appResources: Resources,
    private val loginUseCase: LoginUseCase,
    private val saveAccessTokenUseCase: SaveAccessTokenUseCase,
    getIsAuthenticatedUseCase: GetIsAuthenticatedUseCase,
) : ViewModel() {

    var uiState: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState())
        private set

    var isAuthenticatedFlow: Flow<Boolean> = getIsAuthenticatedUseCase()

    fun login() {
        isLoading(true)
        viewModelScope.launch {
            when (val resources: Resource<TokenResponse> = loginUseCase(uiState.value)) {
                is Resource.Success -> {
                    isLoading(false)
                    resources.data?.let { token ->
                        saveAccessTokenUseCase(token.access)
                    }
                    uiState.update { state ->
                        state.copy(navigateToMainScreen = true)
                    }
                }

                is Resource.NetworkError -> {
                    setMainError(resources.error)
                    isLoading(false)
                }

                is Resource.Error -> {
                    uiState.update { state ->
                        state.copy(errors = resources.errors as LoginError)
                    }
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

    fun setUserPassword(password: String) {
        uiState.update { state ->
            state.copy(password = password)
        }
    }
}