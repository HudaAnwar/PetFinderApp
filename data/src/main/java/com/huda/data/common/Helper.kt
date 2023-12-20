package com.huda.data.common

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.huda.domain.common.responses.BaseResponse
import com.huda.domain.common.responses.ErrorResponse
import retrofit2.Response

object Helper {
    fun <T> handleErrorResponse(response: Response<T>): BaseResponse<T> {
        val baseResponse = BaseResponse<T>()
        baseResponse.status = response.isSuccessful
        if (response.isSuccessful) {
            baseResponse.response = response.body()
        } else {
            val gson = Gson()
            val type = object : TypeToken<ErrorResponse>() {}.type
            baseResponse.errorResponse = gson.fromJson(response.errorBody()!!.charStream(), type)
        }
        return baseResponse
    }
}