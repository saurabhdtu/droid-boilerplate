package com.android.boilerplate.datasource.remote

import com.android.boilerplate.domain.dto.BreedDTO
import com.android.boilerplate.domain.dto.BreedsDTO
import com.android.boilerplate.domain.dto.FactDTO
import com.android.boilerplate.domain.dto.GroupDTO
import com.android.boilerplate.domain.dto.GroupsDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("breeds")
    suspend fun getBreeds(): BreedsDTO

    @GET("breeds/{id}")
    suspend fun getBreedById(@Path("id") breedId: String): BreedDTO

    @GET("facts")
    suspend fun getFacts(): FactDTO

    @GET("groups")
    suspend fun getGroups(): GroupsDTO

    @GET("groups/{id}")
    suspend fun getGroupById(@Path("id") id: String): GroupDTO
}