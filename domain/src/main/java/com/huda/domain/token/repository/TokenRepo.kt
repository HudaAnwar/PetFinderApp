package com.huda.domain.token.repository

import com.huda.domain.common.responses.BaseResponse
import com.huda.domain.token.responses.TokenResponse

interface TokenRepo {
   suspend fun getToken(): BaseResponse<TokenResponse>?
}