package com.ahmedbadr.articlo.app.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class SharedPreferencesHelper(
    context: Context
) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("app", Context.MODE_PRIVATE)


    fun setString(key: String, value: String) {
        sharedPreferences.edit {
            setString(key, value)
            commit()
        }
    }

    fun setBoolean(key: String, value: Boolean) {
        sharedPreferences.edit {
            setBoolean(key, value)
            commit()
        }
    }

    fun getBooleanOrFalse(key: String) : Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    fun getStringOrNull(key: String) : String? {
        return sharedPreferences.getString(key, null)
    }
}