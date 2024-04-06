package com.android.boilerplate.domain.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Breed(
    val id: String,
    val type: String,
    @Json(name = "attributes")
    val attributes: BreedAttributes
)

@JsonClass(generateAdapter = true)
data class BreedAttributes(
    val name: String,
    val description: String,
    val hypoallergenic: Boolean,
    @Json(name = "min_life") val minLife: Int? = null,
    @Json(name = "max_life") val maxLife: Int? = null
)

@JsonClass(generateAdapter = true)
data class BreedsDTO(
    @Json(name = "data") val data: ArrayList<Breed>,
    @Json(name = "links") val links: Links?
)

@JsonClass(generateAdapter = true)
data class BreedDTO(val data: Breed, val links: Links?)