package com.android.boilerplate.ui.screens

import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.boilerplate.domain.dto.Breed
import com.android.boilerplate.ui.screens.breedlist.BreedListState
import com.android.boilerplate.ui.screens.breedlist.BreedListViewModel
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.Test
import kotlin.test.assertNotNull

class BreedListViewModelTest:KoinTest {

    @Test
    fun testBreedListAPI()= runTest{
        val breedListViewModel:BreedListViewModel by inject()
        assertNotNull(breedListViewModel)
        assert(breedListViewModel.stateFlow.value is BreedListState.Loading)
        breedListViewModel.getListOfBreeds()
        val states = mutableListOf<BreedListState>()
        val job = breedListViewModel.stateFlow.collect {
            states.add(it)
        }
        advanceUntilIdle()
        assertTrue(states.size > 1) // Ensure that at least two states were emitted
        assertTrue(states[0] is BreedListState.Loading)
        assertTrue(states[1] is BreedListState.BreedsLoaded)
    }

}