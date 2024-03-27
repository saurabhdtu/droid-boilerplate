package com.android.boilerplate.ui

import com.android.boilerplate.ui.main.MainViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { MainViewModel(get()) }
}