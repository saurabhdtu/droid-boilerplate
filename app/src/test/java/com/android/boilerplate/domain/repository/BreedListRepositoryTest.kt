package com.android.boilerplate.domain.repository

import com.android.boilerplate.datasource.local.sharedPreferenceModule
import com.android.boilerplate.datasource.remote.APIResult
import com.android.boilerplate.domain.repositoryModule
import com.android.boilerplate.testModule
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.koin.compose.koinInject
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.get
import kotlin.test.Test
import kotlin.test.assertTrue

class BreedListRepositoryTest:KoinTest {
    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(testModule, sharedPreferenceModule, repositoryModule)
    }

    @Test
    fun `get breed list`() = runTest{
        val breedListRepositoryTest = get<BreedRepository>()
        val listOfBreeds = breedListRepositoryTest.getListOfBreeds()
        assertTrue { listOfBreeds is APIResult.Success }
        assertTrue { (listOfBreeds as APIResult.Success).data.data.isNotEmpty() }
    }
}