package com.android.boilerplate.ui

import com.android.boilerplate.ui.breedlist.BreedListViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { BreedListViewModel(get()) }
}