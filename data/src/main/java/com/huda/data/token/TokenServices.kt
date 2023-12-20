package com.huda.data.token

import com.huda.domain.token.requests.TokenRequest
import com.huda.domain.token.responses.TokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface TokenServices {
     @POST(Constants.get_Token)
    suspend fun getToken(@Body tokenRequest: TokenRequest):Response<TokenResponse>

}

