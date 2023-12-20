package com.huda.domain.pet_details.responses

import com.google.gson.annotations.SerializedName
import com.huda.domain.common.models.Animal


data class AnimalDetailsResponse (

  @SerializedName("animal" ) var animal : Animal? = Animal()

)