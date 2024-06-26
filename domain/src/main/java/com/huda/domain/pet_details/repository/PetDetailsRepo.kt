package com.huda.domain.pet_details.repository

import com.huda.domain.pet_details.responses.AnimalDetailsResponse
import com.huda.domain.pet_list.responses.TokenResponse
import retrofit2.Response
import retrofit2.http.Path

interface PetDetailsRepo {
    suspend fun getPetDetails(petId:Int): AnimalDetailsResponse?
    suspend fun getToken(): TokenResponse?

}