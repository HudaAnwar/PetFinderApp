package com.huda.domain.common.models

import com.google.gson.annotations.SerializedName


data class Colors (

  @SerializedName("primary"   ) var primary   : String? = null,
  @SerializedName("secondary" ) var secondary : String? = null,
  @SerializedName("tertiary"  ) var tertiary  : String? = null

)