package com.android.boilerplate

import com.android.boilerplate.datasource.local.sharedPreferenceModule
import com.android.boilerplate.datasource.remote.networkModule
import com.android.boilerplate.domain.repositoryModule
import com.android.boilerplate.ui.screens.breedlist.BreedListViewModel
import com.android.boilerplate.ui.viewModelModule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.get
import kotlin.test.assertNotNull

class ModuleTest : KoinTest {

    @Test
    fun checkKoinModules() {
        val breedListViewModel = get<BreedListViewModel>()
        assertNotNull(breedListViewModel)
        assertNotNull(breedListViewModel.stateFlow)

    }
}