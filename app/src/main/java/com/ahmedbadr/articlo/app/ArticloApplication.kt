package com.ahmedbadr.articlo.app

import android.app.Application
import com.ahmedbadr.articlo.app.di.appModule
import com.ahmedbadr.articlo.app.di.clientService
import com.ahmedbadr.articlo.app.di.daoModule
import com.ahmedbadr.articlo.app.di.dataSourceModule
import com.ahmedbadr.articlo.app.di.repositoryModule
import com.ahmedbadr.articlo.app.di.useCaseModule
import com.ahmedbadr.articlo.app.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ArticloApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ArticloApplication)

            modules(
                listOf(
                    appModule,
                    clientService,
                    daoModule,
                    dataSourceModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}