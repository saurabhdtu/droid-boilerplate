package com.android.boilerplate.domain.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.http.Field

@JsonClass(generateAdapter = true)
data class Links(
    val self: String,
    val current: String? = null,
    val next: String? = null,
    val last: String? = null
)
