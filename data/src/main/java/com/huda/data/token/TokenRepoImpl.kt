package com.huda.data.token

import com.huda.data.common.Helper
import com.huda.domain.common.responses.BaseResponse
import com.huda.domain.token.repository.TokenRepo
import com.huda.domain.token.requests.TokenRequest
import com.huda.domain.token.responses.TokenResponse

class TokenRepoImpl(
    private val tokenServices: TokenServices,
    private val tokenRequest: TokenRequest
) : TokenRepo {

    override suspend fun getToken(): BaseResponse<TokenResponse> {
        val response = tokenServices.getToken(tokenRequest)
        return Helper.handleErrorResponse(response)
    }
}