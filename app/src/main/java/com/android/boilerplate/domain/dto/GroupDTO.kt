package com.android.boilerplate.domain.dto

import com.android.boilerplate.domain.model.Group
import com.android.boilerplate.domain.model.Links

data class GroupsDTO (val data: ArrayList<Group>, val links: Links)

data class GroupDTO (val data: Group, val links: Links)
