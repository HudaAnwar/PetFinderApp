package com.huda.domain.pet_list.repository

import com.huda.domain.pet_list.requests.TokenRequest
import com.huda.domain.pet_list.responses.AnimalsListResponse
import com.huda.domain.pet_list.responses.TokenResponse
import com.huda.domain.pet_list.responses.TypesResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PetListRepo {
    suspend fun getTypes():TypesResponse?

    suspend fun getPetsByType(type: String? = null, page: Int = 1): AnimalsListResponse?

    suspend fun getToken(tokenRequest: TokenRequest): TokenResponse?
}