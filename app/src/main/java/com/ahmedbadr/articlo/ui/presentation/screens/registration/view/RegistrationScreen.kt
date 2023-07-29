package com.ahmedbadr.articlo.ui.presentation.screens.registration.view

import android.annotation.SuppressLint
import android.content.res.Resources
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmedbadr.articlo.R
import com.ahmedbadr.articlo.app.extensions.VSpacer
import com.ahmedbadr.articlo.domain.model.uiState.RegistrationUiState
import com.ahmedbadr.articlo.ui.theme.ArticloTheme
import com.ahmedbadr.articlo.ui.widgets.InputTextField
import com.ahmedbadr.articlo.ui.widgets.buttons.BackButton
import com.ahmedbadr.articlo.ui.widgets.buttons.RadioButtonWithLabel
import com.ahmedbadr.articlo.ui.widgets.dialogs.LoadingDialogType
import com.ahmedbadr.articlo.ui.widgets.dialogs.OpenLoadingDialog
import kotlinx.coroutines.flow.MutableStateFlow

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(
    onNavigateToNextScreen : () -> Unit = {},
    onNavigateBack: () -> Unit = {},
    onEmailChange: (value: String) -> Unit = {},
    onPasswordChange: (value: String) -> Unit = {},
    onConfirmPasswordChange: (value: String) -> Unit = {},
    onFullNameChange: (value: String) -> Unit = {},
    onUsernameChange: (value: String) -> Unit = {},
    setIsMale: (value: Boolean) -> Unit = {},
    register: () -> Unit = {},
    registrationUiState: MutableStateFlow<RegistrationUiState>,
) {
    val resources: Resources = LocalContext.current.resources

    val uiState: RegistrationUiState by registrationUiState.collectAsState()

    if (uiState.isSuccessRegistration) {
        onNavigateToNextScreen()
    }
    
    if (uiState.loading) {
        OpenLoadingDialog(LoadingDialogType.REGISTRATION)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    BackButton(onNavigateBack = onNavigateBack)
                },
                elevation = 0.dp,
                backgroundColor = MaterialTheme.colorScheme.background,
            )
        }
    ) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = paddingValues.calculateTopPadding(),
                )
                .verticalScroll(rememberScrollState()),
        ) {
            Text(
                text = resources.getString(R.string.create_an_account),
                style = MaterialTheme.typography.displaySmall.copy(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .padding(end = 16.dp)
                    .align(Alignment.Start)
            )
            16.VSpacer()
            Text(
                text = resources.getString(R.string.don_t_worry_only_ypu_can_see_your_personal_data_no_one_will_be_able_to_see_it),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .align(Alignment.Start)
            )
            32.VSpacer()
            InputTextField(
                value = uiState.fullName,
                labelText = resources.getString(R.string.full_name),
                onTextChange = onFullNameChange,
                errors = uiState.errors.fullNameErrorsList
            )
            16.VSpacer()
            InputTextField(
                value = uiState.username,
                labelText = resources.getString(R.string.username),
                onTextChange = onUsernameChange,
                errors = uiState.errors.usernameErrorsList

            )
            16.VSpacer()
            InputTextField(
                value = uiState.email,
                labelText = resources.getString(R.string.email),
                onTextChange = onEmailChange,
                errors = uiState.errors.emailErrorsList
            )
            16.VSpacer()
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButtonWithLabel(
                    modifier = Modifier
                        .weight(1f),
                    label = resources.getString(R.string.male),
                    selected = uiState.isMale,
                    onSelected = {
                        setIsMale(true)
                    }
                )
                RadioButtonWithLabel(
                    modifier = Modifier
                        .weight(1f),
                    label = resources.getString(R.string.female),
                    selected = !uiState.isMale,
                    onSelected = {
                        setIsMale(false)
                    }
                )
            }
            16.VSpacer()
            InputTextField(
                value = uiState.password,
                labelText = resources.getString(R.string.password),
                onTextChange = onPasswordChange,
                errors = uiState.errors.passwordErrorsList
            )
            16.VSpacer()
            InputTextField(
                value = uiState.confirmPassword,
                labelText = resources.getString(R.string.confirm_password),
                onTextChange = onConfirmPasswordChange,
                errors = uiState.errors.confirmPasswordErrorsList
            )
            16.VSpacer()
            Spacer(modifier = Modifier.weight(1f))
            ElevatedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                onClick = register
            ) {
                Text(text = resources.getString(R.string.create_new_account))
            }
            16.VSpacer()
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun RegistrationScreenLightPreviewEn() {
    ArticloTheme {
        RegistrationScreen(
            registrationUiState = MutableStateFlow(
                RegistrationUiState()
            )
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun RegistrationScreenLightWithLoadingPreviewEn() {
    ArticloTheme {
        RegistrationScreen(
            registrationUiState = MutableStateFlow(
                RegistrationUiState(
                    loading = true
                )
            )
        )
    }
}