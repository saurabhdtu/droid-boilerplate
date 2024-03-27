package com.android.boilerplate.domain

import com.android.boilerplate.domain.repository.BreedRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { BreedRepository(get()) }
}