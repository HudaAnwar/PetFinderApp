package com.huda.domain.pet_list.responses


import com.google.gson.annotations.SerializedName


data class TokenResponse (

    @SerializedName("token_type"   ) var tokenType   : String? = null,
    @SerializedName("expires_in"   ) var expiresIn   : Int?    = null,
    @SerializedName("access_token" ) var accessToken : String? = null

)
