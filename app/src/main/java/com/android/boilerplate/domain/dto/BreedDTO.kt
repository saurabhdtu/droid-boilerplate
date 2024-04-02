package com.android.boilerplate.domain.dto

import com.squareup.moshi.Json

data class Breed(
    val id: String,
    val type: String,
    val attributes: BreedAttributes
)

data class BreedAttributes(
    val name: String,
    val description: String,
    val hypoallergenic: Boolean,
    @Json(name = "min_life") val minLife: Int? = null,
    @Json(name = "max_life") val maxLife: Int? = null
)

data class BreedsDTO(val data: ArrayList<Breed>, val links: Links?)
data class BreedDTO(val data: Breed, val links: Links?)