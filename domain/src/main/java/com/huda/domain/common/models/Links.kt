package com.huda.domain.common.models

import com.google.gson.annotations.SerializedName


data class Links (

    @SerializedName("self"         ) var self         : Self?         = Self(),
    @SerializedName("type", alternate = ["breeds"]) var typeLink         : TypeLink?         = TypeLink(),
    @SerializedName("organization" ) var organization : Organization? = Organization()

)