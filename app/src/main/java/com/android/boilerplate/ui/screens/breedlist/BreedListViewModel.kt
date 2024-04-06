package com.android.boilerplate.ui.screens.breedlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.boilerplate.datasource.remote.APIResult
import com.android.boilerplate.domain.mapper.BreedListMapper
import com.android.boilerplate.domain.repository.BreedRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BreedListViewModel(private val breedRepository: BreedRepository) : ViewModel() {
    private val _stateFlow = MutableStateFlow<BreedListState>(BreedListState.Loading)

    val stateFlow: StateFlow<BreedListState> = _stateFlow
    fun getListOfBreeds() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val state = when (val result = breedRepository.getListOfBreeds()) {
                    is APIResult.Success ->
                        BreedListState.BreedsLoaded(BreedListMapper().map(result.data))

                    is APIResult.Error ->
                        BreedListState.Error(result.errorMessage ?: "")
                }
                withContext(Dispatchers.Main) {
                    _stateFlow.emit(state)
                }
            }
        }
    }
}