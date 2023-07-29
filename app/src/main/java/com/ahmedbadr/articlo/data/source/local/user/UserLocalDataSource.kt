package com.ahmedbadr.articlo.data.source.local.user

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class UserLocalDataSource(
    private val context: Context
) {

    companion object {
        private val Context.appDataStore: DataStore<Preferences> by preferencesDataStore(name = "app")
        private val ACCESS_TOKEN_KEY = stringPreferencesKey("access_token")
    }

    val getAccessTokenFlow: Flow<String> = context.appDataStore.data.map { value: Preferences ->
        value[ACCESS_TOKEN_KEY] ?: ""
    }.flowOn(Dispatchers.IO)

    suspend fun saveAccessToken(token: String) {
        context.appDataStore.edit { preferences ->
            preferences[ACCESS_TOKEN_KEY] = token
        }
    }
}