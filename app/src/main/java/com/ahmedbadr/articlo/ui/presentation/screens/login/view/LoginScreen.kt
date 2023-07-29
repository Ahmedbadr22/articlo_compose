package com.ahmedbadr.articlo.ui.presentation.screens.login.view

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.content.res.Resources
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ahmedbadr.articlo.R
import com.ahmedbadr.articlo.app.extensions.VSpacer
import com.ahmedbadr.articlo.domain.model.error.LoginError
import com.ahmedbadr.articlo.domain.model.uiState.LoginUiState
import com.ahmedbadr.articlo.ui.theme.ArticloTheme
import com.ahmedbadr.articlo.ui.widgets.InputTextField
import com.ahmedbadr.articlo.ui.widgets.PasswordInputTextField
import com.ahmedbadr.articlo.ui.widgets.dialogs.LoadingDialogType
import com.ahmedbadr.articlo.ui.widgets.dialogs.OpenLoadingDialog
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emptyFlow


@Composable
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun LoginScreen(
    onNavigateToRegistrationScreen: () -> Unit = {},
    onPopUpToMainScreen: () -> Unit = {},
    onEmailChange: (value: String) -> Unit = {},
    onPasswordChange: (value: String) -> Unit = {},
    login: () -> Unit = {},
    loginUiStateFlow: MutableStateFlow<LoginUiState>,
    isAuthenticatedFlow: Flow<Boolean>
) {
    val resource: Resources = LocalContext.current.resources
    val loginUiState : LoginUiState by loginUiStateFlow.collectAsStateWithLifecycle()

    if (loginUiState.loading) {
        OpenLoadingDialog(
            loadingDialogType = LoadingDialogType.LOGIN
        )
    }

    LaunchedEffect(isAuthenticatedFlow) {
        isAuthenticatedFlow.collect { isAuthenticated ->
            if (isAuthenticated) {
                onPopUpToMainScreen()
            }
        }
    }

    Scaffold {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
        ) {
            Text(
                text = resource.getString(R.string.hello_there),
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.align(Alignment.Start),
            )
            16.VSpacer()
            Text(
                text = resource.getString(R.string.please_enter_your_username_email_and_password_to_sign_in),
                style = MaterialTheme.typography.bodyLarge,
            )
            16.VSpacer()
            if (loginUiState.mainError.isNotEmpty()) {
                Text(
                    modifier = Modifier.fillMaxSize(),
                    text = loginUiState.mainError,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.error
                )
            }
            16.VSpacer()
            InputTextField(
                value = loginUiState.email,
                labelText = resource.getString(R.string.username_email),
                keyboardType = KeyboardType.Email,
                onTextChange = onEmailChange,
                errors = loginUiState.errors.passwordErrorsList,
            )
            16.VSpacer()
            PasswordInputTextField(
                value = loginUiState.password,
                labelText = resource.getString(R.string.password),
                onTextChange = onPasswordChange,
                errors = loginUiState.errors.passwordErrorsList,
            )
            24.VSpacer()
            TextButton(
                onClick = {}
            ) {
                Text(text = resource.getString(R.string.forgot_password))
            }
            32.VSpacer()
            ElevatedButton(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                onClick = login
            ) {
                Text(text = resource.getString(R.string.login))
            }
            8.VSpacer()
            OutlinedButton(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                onClick = onNavigateToRegistrationScreen
            ) {
                Text(text = resource.getString(R.string.create_new_account))
            }
        }
    }
}


@Preview
@Composable
fun LoginScreenLightPreviewEn() {
    ArticloTheme {
        LoginScreen(
            loginUiStateFlow = MutableStateFlow(LoginUiState("", "")),
            isAuthenticatedFlow = emptyFlow()
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LoginScreenDarkPreviewEn() {
    ArticloTheme {
        LoginScreen(
            loginUiStateFlow = MutableStateFlow(LoginUiState("", "")),
            isAuthenticatedFlow = emptyFlow()
        )
    }
}

@Preview(locale = "ar")
@Composable
fun LoginScreenLightPreviewAr() {
    ArticloTheme {
        LoginScreen(
            loginUiStateFlow = MutableStateFlow(LoginUiState("", "")),
            isAuthenticatedFlow = emptyFlow()
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, locale = "ar")
@Composable
fun LoginScreenDarkPreviewAr() {
    ArticloTheme {
        LoginScreen(
            loginUiStateFlow = MutableStateFlow(LoginUiState(
                email = "",
                password = "",
            )),
            isAuthenticatedFlow = emptyFlow()
        )
    }
}


@Preview(locale = "ar")
@Composable
fun LoginScreenLightWithLoadingPreviewAr() {
    ArticloTheme {
        LoginScreen(
            loginUiStateFlow = MutableStateFlow(LoginUiState(
                email = "",
                password = "",
                loading = true
            )),
            isAuthenticatedFlow = emptyFlow()
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LoginScreenDarkWithLoadingPreviewEn() {
    ArticloTheme {
        LoginScreen(
            loginUiStateFlow = MutableStateFlow(LoginUiState(
                email = "",
                password = "",
                loading = true
            )),
            isAuthenticatedFlow = emptyFlow()
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LoginScreenDarkEmailErrorPreviewEn() {
    ArticloTheme {
        LoginScreen(
            loginUiStateFlow = MutableStateFlow(LoginUiState(
                email = "",
                password = "",
                loading = false,
                errors = LoginError(
                    emailErrorsList = mutableListOf(
                        R.string.this_field_is_required
                    )
                ),
                mainError = "Error"
            )),
            isAuthenticatedFlow = emptyFlow()
        )
    }
}
