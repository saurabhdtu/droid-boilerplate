package com.android.boilerplate

import android.app.Application
import com.android.boilerplate.datasource.local.sharedPreferenceModule
import com.android.boilerplate.datasource.remote.networkModule
import com.android.boilerplate.domain.repositoryModule
import com.android.boilerplate.ui.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            androidLogger()
            modules(sharedPreferenceModule, networkModule, repositoryModule, viewModelModule)
        }
    }
}