package com.huda.domain.common.models

import com.google.gson.annotations.SerializedName


data class Photos (

  @SerializedName("small"  ) var small  : String? = null,
  @SerializedName("medium" ) var medium : String? = null,
  @SerializedName("large"  ) var large  : String? = null,
  @SerializedName("full"   ) var full   : String? = null

)