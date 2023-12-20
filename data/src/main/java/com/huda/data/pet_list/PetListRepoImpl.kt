package com.huda.data.pet_list

import com.huda.domain.pet_list.repository.PetListRepo
import com.huda.domain.pet_list.requests.TokenRequest
import com.huda.domain.pet_list.responses.AnimalsListResponse
import com.huda.domain.pet_list.responses.TokenResponse
import com.huda.domain.pet_list.responses.TypesResponse

class PetListRepoImpl(private  val petListServices: PetListServices):PetListRepo {
    override suspend fun getTypes(): TypesResponse? {
        try {
            val response = petListServices.getTypes()
            if (response.isSuccessful){
                return response.body()
            }else{
                response.errorBody()
            }
        }catch (ex:Exception){
            ex.message
        }
        return null
    }

    override suspend fun getPetsByType(type: String?, page: Int): AnimalsListResponse? {
        TODO("Not yet implemented")
    }

    override suspend fun getToken(tokenRequest: TokenRequest): TokenResponse? {
        TODO("Not yet implemented")
    }
}