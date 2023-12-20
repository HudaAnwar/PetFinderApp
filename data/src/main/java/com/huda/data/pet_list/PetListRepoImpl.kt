package com.huda.data.pet_list

import com.huda.data.common.Helper
import com.huda.domain.pet_list.repository.PetListRepo
import com.huda.domain.pet_list.requests.TokenRequest
import com.huda.domain.pet_list.responses.AnimalsListResponse
import com.huda.domain.pet_list.responses.TokenResponse
import com.huda.domain.pet_list.responses.TypesResponse

class PetListRepoImpl(
    private val petListServices: PetListServices,
    private val tokenRequest: TokenRequest
) : PetListRepo {
    override suspend fun getTypes(): TypesResponse? {
        val response = petListServices.getTypes()
        return Helper.handleUnAuthResponse(response,::getToken,tokenRequest)
    }



    override suspend fun getPetsByType(type: String?, page: Int): AnimalsListResponse? {
        val response = petListServices.getPetsByType(type, page)
        return Helper.handleUnAuthResponse(response, ::getToken,tokenRequest)
    }

    override suspend fun getToken(): TokenResponse? {
        val response = petListServices.getToken(tokenRequest)
        return response.body()
    }
}