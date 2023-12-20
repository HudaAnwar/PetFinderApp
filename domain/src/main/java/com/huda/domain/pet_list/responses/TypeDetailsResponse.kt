package com.huda.domain.pet_list.responses

import com.google.gson.annotations.SerializedName
import com.huda.domain.pet_list.models.Type


data class TypeDetailsResponse (

  @SerializedName("type" ) var type : Type? = Type()

)