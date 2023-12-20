package com.huda.data.pet_details

import com.huda.domain.pet_details.responses.AnimalDetailsResponse
import com.huda.domain.pet_list.requests.TokenRequest
import com.huda.domain.pet_list.responses.TokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PetDetailsServices {
    @GET(Constants.get_pet_details)
    suspend fun getPetDetails(@Path("id")petId:Int):Response<AnimalDetailsResponse>

    @POST(com.huda.data.pet_list.Constants.get_Token)
    suspend fun getToken(@Body tokenRequest: TokenRequest):Response<TokenResponse>
}