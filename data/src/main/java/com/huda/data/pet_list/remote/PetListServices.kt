package com.huda.data.pet_list.remote

import com.huda.data.pet_list.Constants
import com.huda.domain.pet_list.responses.AnimalsListResponse
import com.huda.domain.pet_list.responses.TypesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PetListServices {
    @GET(Constants.get_types)
    suspend fun getTypes():Response<TypesResponse>

    @GET(Constants.get_pets_by_type)
    suspend fun getPetsByType(
        @Query("type") type: String? = null,
        @Query("page") page: Int = 1
    ): Response<AnimalsListResponse>

}

