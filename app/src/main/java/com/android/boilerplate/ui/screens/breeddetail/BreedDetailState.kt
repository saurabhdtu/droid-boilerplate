package com.android.boilerplate.ui.screens.breeddetail

import com.android.boilerplate.domain.models.BreedDetail

sealed class BreedDetailState {
    data object Loading:BreedDetailState()
    data class Loaded(val breed: BreedDetail) : BreedDetailState()
    data class Error(val message: String) : BreedDetailState()
}


