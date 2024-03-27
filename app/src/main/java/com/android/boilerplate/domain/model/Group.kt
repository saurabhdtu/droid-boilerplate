package com.android.boilerplate.domain.model

import com.android.boilerplate.domain.dto.RelationshipDTO

data class Group(
    val id: String,
    val type: String,
    val attributes: GroupAttributes,
    val relationships: RelationshipDTO
)