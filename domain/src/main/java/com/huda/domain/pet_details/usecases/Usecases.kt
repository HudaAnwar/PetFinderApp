package com.huda.domain.pet_details.usecases

import com.huda.domain.pet_details.repository.PetDetailsRepo

class GetPetDetailsUseCase(private val petDetailsRepo: PetDetailsRepo) {
    suspend operator fun invoke(petId:Int) = petDetailsRepo.getPetDetails(petId)
}
