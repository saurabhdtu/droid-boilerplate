package com.android.boilerplate.domain.dto

data class Fact(val id: String, val type: String, val attributes: FactAttributes)
data class FactAttributes(val body: String)

data class FactDTO(val data: ArrayList<Fact>)