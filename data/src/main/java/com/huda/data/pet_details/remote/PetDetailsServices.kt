package com.huda.data.pet_details.remote

import com.huda.data.pet_details.Constants
import com.huda.domain.pet_details.responses.AnimalDetailsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PetDetailsServices {
    @GET(Constants.get_pet_details)
    suspend fun getPetDetails(@Path("id")petId:Int):Response<AnimalDetailsResponse>

}