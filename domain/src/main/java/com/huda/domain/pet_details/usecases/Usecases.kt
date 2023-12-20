package com.huda.domain.pet_details.usecases

import com.huda.domain.pet_details.repository.PetDetailsRepo
import com.huda.domain.pet_list.repository.PetListRepo
import com.huda.domain.pet_list.requests.TokenRequest

class GetPetDetailsUseCase(private val petDetailsRepo: PetDetailsRepo) {
    suspend operator fun invoke(petId:Int) = petDetailsRepo.getPetDetails(petId)
}
