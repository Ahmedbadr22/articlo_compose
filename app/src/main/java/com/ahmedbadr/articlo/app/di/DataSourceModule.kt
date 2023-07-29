package com.ahmedbadr.articlo.app.di


import com.ahmedbadr.articlo.data.source.local.country.CountryLocalDataSource
import com.ahmedbadr.articlo.data.source.local.country.CountryLocalDataSourceImpl
import com.ahmedbadr.articlo.data.source.local.user.UserLocalDataSource
import com.ahmedbadr.articlo.data.source.remote.authentication.AuthenticationRemoteDatasource
import com.ahmedbadr.articlo.data.source.remote.authentication.AuthenticationRemoteDatasourceImpl
import com.ahmedbadr.articlo.data.source.remote.country.CountryRemoteDataSource
import com.ahmedbadr.articlo.data.source.remote.country.CountryRemoteDataSourceImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataSourceModule = module {
    // Authentication
    singleOf(::AuthenticationRemoteDatasourceImpl) { bind<AuthenticationRemoteDatasource>()}

    // user
    singleOf(::UserLocalDataSource)



    // Country
    singleOf(::CountryRemoteDataSourceImpl) { bind<CountryRemoteDataSource>() }
    singleOf(::CountryLocalDataSourceImpl) { bind<CountryLocalDataSource>() }

}