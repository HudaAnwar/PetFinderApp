package com.huda.data.common

import com.huda.domain.pet_list.requests.TokenRequest
import com.huda.domain.pet_list.responses.TokenResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Response

object Helper {
    fun <T> handleUnAuthResponse(
        response: Response<T>,
        getToken: suspend () -> TokenResponse?,
        tokenRequest: TokenRequest
    ): T? {
        return if (response.isSuccessful) {
            response.body()
        } else {
            val jsonObj = JSONObject(response.errorBody()?.charStream()!!.readText())
            if (jsonObj.has("title")) {
                val title = jsonObj.getString("title")
                if (title == Constants.Unauthenticated) {
                    CoroutineScope(Dispatchers.IO).launch {
                        getToken()
                    }
                }
            }
            null
        }

    }
}