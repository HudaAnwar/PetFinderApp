package com.huda.domain.pet_list.usecases

import com.huda.domain.pet_list.repository.PetListRepo


class GetTypesUseCase(private val petListRepo: PetListRepo) {
    suspend operator fun invoke() = petListRepo.getTypes()
}
class FetchTypesUseCase(private val petListRepo: PetListRepo) {
    suspend operator fun invoke() = petListRepo.fetchTypes()
}

class GetPetsByTypeUseCase(private val petListRepo: PetListRepo) {
    suspend operator fun invoke(type:String?,page:Int=1) = petListRepo.getPetsByType(type,page)
}
class FetchPetsByTypeUseCase(private val petListRepo: PetListRepo) {
    suspend operator fun invoke(type:String?) = petListRepo.fetchPetsByType(type)
}

