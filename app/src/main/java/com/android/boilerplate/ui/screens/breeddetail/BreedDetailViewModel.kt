package com.android.boilerplate.ui.screens.breeddetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.boilerplate.datasource.remote.APIResult
import com.android.boilerplate.domain.mapper.BreedDetailMapper
import com.android.boilerplate.domain.repository.BreedRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BreedDetailViewModel(private val breedRepository: BreedRepository) : ViewModel() {
    private val _stateFlow = MutableStateFlow<BreedDetailState>(BreedDetailState.Loading)
    val stateFlow: StateFlow<BreedDetailState> = _stateFlow

    fun loadBreedDetail(breedId: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val state = when (val breedDetailResult = breedRepository.getBreedById(breedId)) {
                    is APIResult.Success ->
                        BreedDetailState.Loaded(
                            BreedDetailMapper().map(
                                breedDetailResult.data
                            )
                        )

                    is APIResult.Error ->
                        BreedDetailState.Error(
                            breedDetailResult.errorMessage ?: ""
                        )
                }
                withContext(Dispatchers.Main) {
                    _stateFlow.emit(state)
                }
            }
        }

    }
}