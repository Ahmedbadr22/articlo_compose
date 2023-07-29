package com.ahmedbadr.articlo.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ahmedbadr.articlo.ui.presentation.screens.login.view.LoginScreen
import com.ahmedbadr.articlo.ui.presentation.screens.login.viewModel.LoginViewModel
import com.ahmedbadr.articlo.ui.presentation.screens.main.view.MainScreen
import com.ahmedbadr.articlo.ui.presentation.screens.onBoarding.view.OnBoardingScreen
import com.ahmedbadr.articlo.ui.presentation.screens.registration.view.RegistrationScreen
import com.ahmedbadr.articlo.ui.presentation.screens.selectCountry.view.SelectYourCountryScreen
import com.ahmedbadr.articlo.ui.presentation.screens.registration.viewModel.RegistrationViewModel
import com.ahmedbadr.articlo.ui.presentation.screens.selectCountry.viewModel.CountryViewModel
import com.ahmedbadr.articlo.ui.presentation.screens.splash.view.SplashScreen
import com.ahmedbadr.articlo.ui.presentation.screens.topic.view.SelectTopicsOfInterestScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalPagerApi::class)
@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    fun navigateBack() {
        navController.popBackStack()
    }

    val countryViewModel: CountryViewModel = koinViewModel()
    val loginViewModel: LoginViewModel = koinViewModel()

    NavHost(navController = navController, startDestination = Routes.SPLASH.name) {
        composable(Routes.SPLASH.name) {
            SplashScreen(
                onNavigateToOnBoardingScreen = {
                    navController.navigate(Routes.MAIN.name) {
                        popUpTo(navController.graph.id) {
                            inclusive = true
                        }
                    }
                },
                listCountries = countryViewModel::listCountriesFromRemoteToLocal
            )
        }
        composable(Routes.ON_BOARDING.name) {
            OnBoardingScreen(
                onNavigateToLoginScreen = {
                    navController.navigate(Routes.LOGIN.name){
                        popUpTo(navController.graph.id) {
                            inclusive = true
                        }
                        launchSingleTop = true
                        restoreState = false
                    }
                },
            )
        }
        composable(Routes.LOGIN.name) {
            LoginScreen(
                onNavigateToRegistrationScreen = {
                    navController.navigate(Routes.REGISTRATION_SELECT_COUNTRY.name)
                },
                onPopUpToMainScreen = {
                    navController.popBackStack()
                },
                onEmailChange = loginViewModel::setUserEmail,
                onPasswordChange = loginViewModel::setUserPassword,
                login = loginViewModel::login,
                loginUiStateFlow = loginViewModel.uiState,
                isAuthenticatedFlow = loginViewModel.isAuthenticatedFlow
            )
        }
        composable(Routes.REGISTRATION.name) {
            val registrationViewModel: RegistrationViewModel = koinViewModel()
            RegistrationScreen(
                onNavigateToNextScreen = {
                    navController.navigate(Routes.REGISTRATION_SELECT_COUNTRY.name)
                },
                onNavigateBack = ::navigateBack,
                registrationUiState = registrationViewModel.uiState,
                onEmailChange = registrationViewModel::setUserEmail,
                onFullNameChange = registrationViewModel::setFullName,
                onUsernameChange = registrationViewModel::setUsername,
                onPasswordChange = registrationViewModel::setUserPassword,
                onConfirmPasswordChange = registrationViewModel::setConfirmPassword,
                setIsMale = registrationViewModel::setIsMale,
                register = registrationViewModel::register,
            )
        }
        composable(Routes.REGISTRATION_SELECT_COUNTRY.name) {
            SelectYourCountryScreen(
                countriesFlow = countryViewModel.countriesStateFlow
            )
        }
        composable(Routes.SELECT_YOUR_TOPIC_OF_INTEREST.name) {
            SelectTopicsOfInterestScreen()
        }
        composable(Routes.MAIN.name) {
            MainScreen(
                onNavigateToLoginScreen = {
                    navController.navigate(Routes.LOGIN.name)
                },
                isAuthenticatedFlow = loginViewModel.isAuthenticatedFlow
            )
        }
    }
}