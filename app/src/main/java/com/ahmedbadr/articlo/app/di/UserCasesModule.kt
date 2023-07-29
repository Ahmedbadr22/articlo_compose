package com.ahmedbadr.articlo.app.di


import com.ahmedbadr.articlo.domain.usecase.authentication.CreateUserAccountUseCase
import com.ahmedbadr.articlo.domain.usecase.user.GetAccessTokenFlowUseCase
import com.ahmedbadr.articlo.domain.usecase.user.GetIsAuthenticatedUseCase
import com.ahmedbadr.articlo.domain.usecase.authentication.LoginUseCase
import com.ahmedbadr.articlo.domain.usecase.user.SaveAccessTokenUseCase
import com.ahmedbadr.articlo.domain.usecase.country.GetCountriesFlowUseCase
import com.ahmedbadr.articlo.domain.usecase.country.ListCountriesFromRemoteToLocalUseCase
import com.ahmedbadr.articlo.domain.usecase.user.GetUserFullNameFlowUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModule = module {
    // auth
    singleOf(::LoginUseCase)
    singleOf(::CreateUserAccountUseCase)

    // user
    singleOf(::SaveAccessTokenUseCase)
    singleOf(::GetIsAuthenticatedUseCase)
    singleOf(::GetAccessTokenFlowUseCase)
    singleOf(::GetUserFullNameFlowUseCase)



    // country
    singleOf(::ListCountriesFromRemoteToLocalUseCase)
    singleOf(::GetCountriesFlowUseCase)
}