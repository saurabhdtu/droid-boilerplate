package com.android.boilerplate.domain.mapper

import com.android.boilerplate.domain.dto.BreedDTO
import com.android.boilerplate.domain.models.BreedDetail

class BreedDetailMapper : Mapper<BreedDTO, BreedDetail> {
    override fun map(from: BreedDTO): BreedDetail {
        return BreedDetail(from.data)
    }
}