package com.huda.domain.token.requests

import com.google.gson.annotations.SerializedName

data class TokenRequest(
    @SerializedName("grant_type"    ) var grantType    : String? = null,
    @SerializedName("client_id"     ) var clientId     : String? = null,
    @SerializedName("client_secret" ) var clientSecret : String? = null
)
