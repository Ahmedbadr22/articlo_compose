package com.ahmedbadr.articlo.app.di



import android.app.Application
import android.content.res.Resources
import androidx.room.Room
import com.ahmedbadr.articlo.app.constants.API
import com.ahmedbadr.articlo.app.constants.DB
import com.ahmedbadr.articlo.app.db.AppDatabase
import com.ahmedbadr.articlo.app.utils.SharedPreferencesHelper
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {

    single<Retrofit> {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl(API.BASE_URL)
            .build()
    }

    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            DB.DATABASE_NAME,
        ).build()
    }

    single<Resources> {
        get<Application>().resources
    }

    single {
        get<Application>().applicationContext
    }
}