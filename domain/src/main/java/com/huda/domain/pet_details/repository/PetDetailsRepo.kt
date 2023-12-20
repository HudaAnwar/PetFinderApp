package com.huda.domain.pet_details.repository

import com.huda.domain.common.responses.BaseResponse
import com.huda.domain.pet_details.responses.AnimalDetailsResponse
import com.huda.domain.token.responses.TokenResponse

interface PetDetailsRepo {
    suspend fun getPetDetails(petId:Int): BaseResponse<AnimalDetailsResponse>?

}