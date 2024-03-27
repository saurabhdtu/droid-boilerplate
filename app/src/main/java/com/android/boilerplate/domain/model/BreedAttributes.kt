package com.android.boilerplate.domain.model

import com.squareup.moshi.Json

data class BreedAttributes(
    val name: String,
    val description: String,
    val hypoallergenic: Boolean,
    @Json(name = "min_life") val minLife: Int?,
    @Json(name = "max_life") val maxLife: Int?
)
