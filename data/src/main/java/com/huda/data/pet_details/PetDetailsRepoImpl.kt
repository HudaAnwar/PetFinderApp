package com.huda.data.pet_details

import com.huda.data.common.Helper
import com.huda.domain.common.responses.BaseResponse
import com.huda.domain.pet_details.repository.PetDetailsRepo
import com.huda.domain.pet_details.responses.AnimalDetailsResponse
import com.huda.domain.token.requests.TokenRequest
import com.huda.domain.token.responses.TokenResponse

class PetDetailsRepoImpl(
    private val petDetailsServices: PetDetailsServices
) : PetDetailsRepo {
    override suspend fun getPetDetails(petId: Int): BaseResponse<AnimalDetailsResponse> {
       val response= petDetailsServices.getPetDetails(petId)
        return Helper.handleErrorResponse(response)
    }

}