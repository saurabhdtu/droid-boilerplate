package com.android.boilerplate.domain.mapper

import com.android.boilerplate.domain.dto.BreedsDTO
import com.android.boilerplate.domain.models.BreedList

class BreedListMapper : Mapper<BreedsDTO, BreedList> {
    override fun map(from: BreedsDTO): BreedList {
        return BreedList(from.data, from.links?.next)
    }
}