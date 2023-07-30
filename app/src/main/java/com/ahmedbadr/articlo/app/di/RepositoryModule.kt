package com.ahmedbadr.articlo.app.di


import com.ahmedbadr.articlo.data.repository.authentication.AuthenticationRepositoryImpl
import com.ahmedbadr.articlo.data.repository.country.CountryRepositoryImpl
import com.ahmedbadr.articlo.data.repository.topic.TopicRepositoryImpl
import com.ahmedbadr.articlo.domain.repository.AuthenticationRepository
import com.ahmedbadr.articlo.domain.repository.CountryRepository
import com.ahmedbadr.articlo.domain.repository.TopicRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::AuthenticationRepositoryImpl) { bind<AuthenticationRepository>() }

    // country
    singleOf(::CountryRepositoryImpl) { bind<CountryRepository>() }

    // topic
    singleOf(::TopicRepositoryImpl) { bind<TopicRepository>() }
}