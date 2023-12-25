package com.huda.data.pet_details

import com.huda.data.common.Helper
import com.huda.data.pet_details.local.PetDetailsDao
import com.huda.data.pet_details.remote.PetDetailsServices
import com.huda.domain.common.models.Animal
import com.huda.domain.common.responses.BaseResponse
import com.huda.domain.pet_details.repository.PetDetailsRepo
import com.huda.domain.pet_details.responses.AnimalDetailsResponse
import com.huda.domain.common.PetsMapper
import com.huda.domain.common.responses.ErrorResponse

class PetDetailsRepoImpl(
    private val petDetailsServices: PetDetailsServices,
    private val petDetailsDao: PetDetailsDao
) : PetDetailsRepo, PetsMapper {
    override suspend fun getPetDetails(petId: Int): BaseResponse<AnimalDetailsResponse> {
        return try {
            val response = petDetailsServices.getPetDetails(petId)
            Helper.handleErrorResponse(response, null)
        } catch (ex: Exception) {
            BaseResponse(
                null,
                ErrorResponse("exception", title = "exception", status = 0, detail = ex.message),
                false
            )
        }
    }

    override suspend fun fetchPetDetails(petId: Int): Animal {
        val petEntity = petDetailsDao.getPetById(petId)
        val animal = animalEntityToAnimalMapper(petEntity)
        return animal
    }


}