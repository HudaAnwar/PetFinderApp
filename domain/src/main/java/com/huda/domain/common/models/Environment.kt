package com.huda.domain.common.models

import com.google.gson.annotations.SerializedName


data class Environment (

  @SerializedName("children" ) var children : String?  = null,
  @SerializedName("dogs"     ) var dogs     : String?  = null,
  @SerializedName("cats"     ) var cats     : Boolean? = null

)