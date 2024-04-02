package com.android.boilerplate.domain.dto

data class Links(
    val self: String,
    val current: String? = null,
    val next: String? = null,
    val last: String? = null
)
