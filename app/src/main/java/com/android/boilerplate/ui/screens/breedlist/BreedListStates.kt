package com.android.boilerplate.ui.screens.breedlist

import com.android.boilerplate.domain.models.BreedList

sealed class BreedListState{
    data object Loading : BreedListState()
    data class BreedsLoaded(val breedList: BreedList): BreedListState()
    class Error(val message: String): BreedListState()
}
