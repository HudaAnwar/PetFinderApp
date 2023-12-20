package com.huda.data.pet_list

import com.huda.data.common.Helper
import com.huda.domain.common.responses.BaseResponse
import com.huda.domain.pet_list.repository.PetListRepo
import com.huda.domain.pet_list.responses.AnimalsListResponse
import com.huda.domain.token.responses.TokenResponse
import com.huda.domain.pet_list.responses.TypesResponse

class PetListRepoImpl(
    private val petListServices: PetListServices
) : PetListRepo {
    override suspend fun getTypes(): BaseResponse<TypesResponse> {
        val response = petListServices.getTypes()
        return Helper.handleErrorResponse(response)
    }

    override suspend fun getPetsByType(type: String?, page: Int): BaseResponse<AnimalsListResponse> {
        val response = petListServices.getPetsByType(type, page)
        return Helper.handleErrorResponse(response)
    }
}