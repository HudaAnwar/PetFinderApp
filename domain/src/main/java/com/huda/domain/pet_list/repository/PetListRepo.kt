package com.huda.domain.pet_list.repository

import com.huda.domain.common.responses.BaseResponse
import com.huda.domain.pet_list.responses.AnimalsListResponse
import com.huda.domain.pet_list.responses.TypesResponse

interface PetListRepo {
    suspend fun getTypes(): BaseResponse<TypesResponse>?

    suspend fun getPetsByType(type: String? = null, page: Int = 1): BaseResponse<AnimalsListResponse>?

}