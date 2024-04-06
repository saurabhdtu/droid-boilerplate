package com.android.boilerplate.domain.dto

import com.google.gson.annotations.SerializedName

//import com.squareup.moshi.Json
//import com.squareup.moshi.JsonClass

//@JsonClass(generateAdapter = true)
data class Breed(
    val id: String,
    val type: String,
//    @Json(name = "attributes")
    val attributes: BreedAttributes
)

//@JsonClass(generateAdapter = true)
data class BreedAttributes(
    val name: String,
    val description: String,
    val hypoallergenic: Boolean,
    val life: Life? = null,
    @SerializedName("male_weight") val maleWeight: MaleWeight? = null,
    @SerializedName("female_weight") val femaleWeight: FemaleWeight? = null
)

data class Life(val max: Int, val min: Int)
data class MaleWeight(val max: Int, val min: Int)
data class FemaleWeight(val max: Int, val min: Int)

//@JsonClass(generateAdapter = true)
data class BreedsDTO(
    val data: ArrayList<Breed>,
    val links: Links?
)

data class BreedDTO(val data: Breed, val links: Links?)