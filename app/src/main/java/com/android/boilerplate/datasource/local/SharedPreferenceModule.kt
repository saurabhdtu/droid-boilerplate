package com.android.boilerplate.datasource.local

import android.content.Context
import org.koin.dsl.module


val sharedPreferenceModule = module {
    single { SharedPreferenceManager(get()) }
}

class SharedPreferenceManager(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)

    fun writeString(key: String, value: String) {
        with(sharedPreferences.edit()) {
            putString(key, value)
            apply()
        }
    }

    fun readString(key: String, defaultValue: String = ""): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

}