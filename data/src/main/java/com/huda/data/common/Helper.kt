package com.huda.data.common

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.huda.domain.common.responses.BaseResponse
import com.huda.domain.common.responses.ErrorResponse
import com.huda.domain.pet_list.responses.AnimalsListResponse
import retrofit2.Response
import kotlin.reflect.KFunction1

object Helper {
    fun <T> handleErrorResponse(
        response: Response<T>,
        cacheData: ((T?,Boolean)->Unit)?,
        deleteCache: Boolean = false
    ): BaseResponse<T> {
        val baseResponse = BaseResponse<T>()
        baseResponse.status = response.isSuccessful
        if (response.isSuccessful) {
            if (cacheData!=null) { cacheData(response.body(),deleteCache) }
            baseResponse.response = response.body()
        } else {
            val gson = Gson()
            val type = object : TypeToken<ErrorResponse>() {}.type
            baseResponse.errorResponse = gson.fromJson(response.errorBody()!!.charStream(), type)
        }
        return baseResponse
    }
}