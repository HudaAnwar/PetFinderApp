package com.huda.data.pet_details

import com.huda.domain.pet_details.responses.AnimalDetailsResponse
import com.huda.domain.token.requests.TokenRequest
import com.huda.domain.token.responses.TokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PetDetailsServices {
    @GET(Constants.get_pet_details)
    suspend fun getPetDetails(@Path("id")petId:Int):Response<AnimalDetailsResponse>

}