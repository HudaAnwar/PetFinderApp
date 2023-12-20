package com.huda.domain.pet_list.responses

import com.google.gson.annotations.SerializedName
import com.huda.domain.common.models.Animal
import com.huda.domain.pet_list.models.Pagination


data class AnimalsListResponse (

  @SerializedName("animals"    ) var animals    : ArrayList<Animal> = arrayListOf(),
  @SerializedName("pagination" ) var pagination : Pagination?        = Pagination()

)