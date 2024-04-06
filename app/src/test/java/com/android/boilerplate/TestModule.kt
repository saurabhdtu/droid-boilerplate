package com.android.boilerplate

import com.android.boilerplate.datasource.remote.APIService
import com.android.boilerplate.datasource.remote.APIServiceTestImpl
import org.junit.runner.manipulation.Ordering.Context
import org.koin.core.module.Module
import org.koin.dsl.module
import org.mockito.Mockito


val testModule: Module = module {
    // Override the original Retrofit instance with a mock
    single<APIService> { APIServiceTestImpl() }

    // Provide a mock implementation for the context
    single<Context> { Mockito.mock(Context::class.java) }

}