package com.huda.domain.common.responses

import com.google.gson.annotations.SerializedName

data class ErrorResponse (

    @SerializedName("type"   ) var type   : String? = null,
    @SerializedName("status" ) var status : Int?    = null,
    @SerializedName("title"  ) var title  : String? = null,
    @SerializedName("detail" ) var detail : String? = null

)
