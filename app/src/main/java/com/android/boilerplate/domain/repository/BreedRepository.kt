package com.android.boilerplate.domain.repository

import com.android.boilerplate.datasource.remote.APIResult
import com.android.boilerplate.datasource.remote.APIService
import com.android.boilerplate.datasource.remote.safeApiCall
import com.android.boilerplate.domain.dto.BreedDTO
import com.android.boilerplate.domain.dto.BreedsDTO

class BreedRepository(private val apiService: APIService) {
    suspend fun getListOfBreeds(): APIResult<BreedsDTO> {
        return safeApiCall { apiService.getBreeds() }
    }

    suspend fun getBreedById(breedId: String): APIResult<BreedDTO> {
        return safeApiCall { apiService.getBreedById(breedId) }
    }
}