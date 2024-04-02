package com.android.boilerplate.datasource.remote

import com.android.boilerplate.domain.dto.Breed
import com.android.boilerplate.domain.dto.BreedAttributes
import com.android.boilerplate.domain.dto.BreedDTO
import com.android.boilerplate.domain.dto.BreedsDTO
import com.android.boilerplate.domain.dto.FactDTO
import com.android.boilerplate.domain.dto.GroupDTO
import com.android.boilerplate.domain.dto.GroupsDTO
import com.android.boilerplate.domain.dto.Links
import kotlin.random.Random

class APIServiceTestImpl : APIService {
    private val testBreeds: ArrayList<Breed> = ArrayList<Breed>().apply {
        (1..10).forEach { i ->
            this.add(
                Breed(
                    "$i",
                    "Domestic$i",
                    BreedAttributes("Name$i", "Good dog $i", Random.nextBoolean())
                )
            )
        }
    }
    private val testLink = Links("https://self.com")
    override suspend fun getBreeds(): BreedsDTO = BreedsDTO(testBreeds, testLink)

    override suspend fun getBreedById(breedId: String): BreedDTO {
        val breed = testBreeds.find { breed -> breed.id == breedId } ?: throw Exception("Not found")
        return BreedDTO(breed, testLink)
    }

    override suspend fun getFacts(): FactDTO {
        TODO("Not yet implemented")
    }

    override suspend fun getGroups(): GroupsDTO {
        TODO("Not yet implemented")
    }

    override suspend fun getGroupById(id: String): GroupDTO {
        TODO("Not yet implemented")
    }
}