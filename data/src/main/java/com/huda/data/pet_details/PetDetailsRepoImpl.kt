package com.huda.data.pet_details

import com.huda.domain.pet_details.repository.PetDetailsRepo
import com.huda.domain.pet_details.responses.AnimalDetailsResponse

class PetDetailsRepoImpl(private val petDetailsServices: PetDetailsServices):PetDetailsRepo {
    override suspend fun getPetDetails(petId: Int): AnimalDetailsResponse? {
        TODO("Not yet implemented")
    }
}