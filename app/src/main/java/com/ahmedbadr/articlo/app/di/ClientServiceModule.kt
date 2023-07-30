package com.ahmedbadr.articlo.app.di

import com.ahmedbadr.articlo.data.clientService.AuthenticationClientService
import com.ahmedbadr.articlo.data.clientService.CountryClientService
import com.ahmedbadr.articlo.data.clientService.TopicClientService
import org.koin.dsl.module
import retrofit2.Retrofit

val clientService = module {
    single {
        get<Retrofit>().create(AuthenticationClientService::class.java)
    }

    single {
        get<Retrofit>().create(CountryClientService::class.java)
    }

    single {
        get<Retrofit>().create(TopicClientService::class.java)

    }
}