package com.huda.data.pet_details

import com.huda.data.common.Helper
import com.huda.domain.pet_details.repository.PetDetailsRepo
import com.huda.domain.pet_details.responses.AnimalDetailsResponse
import com.huda.domain.pet_list.requests.TokenRequest
import com.huda.domain.pet_list.responses.TokenResponse

class PetDetailsRepoImpl(
    private val petDetailsServices: PetDetailsServices,
    private val tokenRequest: TokenRequest
) : PetDetailsRepo {
    override suspend fun getPetDetails(petId: Int): AnimalDetailsResponse? {
       val response= petDetailsServices.getPetDetails(petId)
        return Helper.handleUnAuthResponse(response,::getToken,tokenRequest)
    }

    override suspend fun getToken(): TokenResponse? {
        val response = petDetailsServices.getToken(tokenRequest)
        return response.body()
    }
}