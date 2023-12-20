package com.huda.domain.pet_list.models

import com.google.gson.annotations.SerializedName
import com.huda.domain.common.models.Links


data class Type (

  @SerializedName("name"    ) var name    : String?           = null,
  @SerializedName("coats"   ) var coats   : ArrayList<String> = arrayListOf(),
  @SerializedName("colors"  ) var colors  : ArrayList<String> = arrayListOf(),
  @SerializedName("genders" ) var genders : ArrayList<String> = arrayListOf(),
  @SerializedName("_links"  ) var Links   : Links?            = Links()

)