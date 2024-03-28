package com.android.boilerplate.domain.dto

data class Group(
    val id: String,
    val type: String,
    val attributes: GroupAttributes,
    val relationships: RelationshipDTO
)

data class GroupAttributes(val name: String)

data class GroupsDTO(val data: ArrayList<Group>, val links: Links)

data class GroupDTO(val data: Group, val links: Links)
