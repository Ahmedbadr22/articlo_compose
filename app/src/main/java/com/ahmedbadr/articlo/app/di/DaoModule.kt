package com.ahmedbadr.articlo.app.di

import com.ahmedbadr.articlo.app.db.AppDatabase
import org.koin.dsl.module

val daoModule = module {
    single {
        get<AppDatabase>().getCountryDao()
    }

    single {
        get<AppDatabase>().getTopicDao()
    }
}