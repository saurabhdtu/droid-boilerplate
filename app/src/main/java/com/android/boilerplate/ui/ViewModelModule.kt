package com.android.boilerplate.ui

import com.android.boilerplate.ui.screens.breedlist.BreedListViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { BreedListViewModel(get()) }
}