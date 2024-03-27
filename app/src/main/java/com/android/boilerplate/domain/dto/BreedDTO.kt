package com.android.boilerplate.domain.dto

import com.android.boilerplate.domain.model.Breed
import com.android.boilerplate.domain.model.Links


data class BreedsDTO(val data: ArrayList<Breed>, val links: Links?)
data class BreedDTO(val data: Breed, val links: Links?)