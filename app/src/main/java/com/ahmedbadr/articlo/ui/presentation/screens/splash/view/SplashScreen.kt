package com.ahmedbadr.articlo.ui.presentation.screens.splash.view

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.content.res.Resources
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmedbadr.articlo.R
import com.ahmedbadr.articlo.app.constants.App
import com.ahmedbadr.articlo.ui.widgets.AppLogo
import com.ahmedbadr.articlo.ui.theme.ArticloTheme
import kotlinx.coroutines.delay


@Composable
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun SplashScreen(
    onNavigateToOnBoardingScreen : () -> Unit = {},
    onNavigateToLoginScreen : () -> Unit = {},
    listCountries : () -> Unit = {},
) {
    val resources: Resources = LocalContext.current.resources
    val currentOnNavigateToOnBoardingScreen by rememberUpdatedState(onNavigateToOnBoardingScreen)

    LaunchedEffect(Unit) {
        listCountries()
        delay(App.SPLASH_TIME)
        currentOnNavigateToOnBoardingScreen()
    }

    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.weight(1.0F))
            AppLogo(
                modifier = Modifier
                    .height(160.dp)
                    .width(160.dp)
            )
            Text(
                text = resources.getString(R.string.app_name),
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 30.sp),
                modifier = Modifier.paddingFromBaseline(top = 50.dp)
            )
            Spacer(modifier = Modifier.weight(2.0F))
        }
    }
}

@Preview
@Composable
fun SplashScreenLightModePreview() {
    ArticloTheme {
        SplashScreen()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SplashScreenDarkModePreview() {
    ArticloTheme {
        SplashScreen()
    }
}