package com.ahmedbadr.articlo.app.di


import com.ahmedbadr.articlo.ui.presentation.screens.login.viewModel.LoginViewModel
import com.ahmedbadr.articlo.ui.presentation.screens.main.viewModel.MainViewModel
import com.ahmedbadr.articlo.ui.presentation.screens.registration.viewModel.RegistrationViewModel
import com.ahmedbadr.articlo.ui.presentation.screens.selectCountry.viewModel.CountryViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module


val viewModelModule = module {
    viewModelOf(::LoginViewModel)
    viewModelOf(::RegistrationViewModel)
    viewModelOf(::CountryViewModel)
    viewModelOf(::MainViewModel)
}