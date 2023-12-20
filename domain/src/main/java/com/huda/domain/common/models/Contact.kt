package com.huda.domain.common.models

import com.google.gson.annotations.SerializedName
import com.huda.domain.common.models.Address


data class Contact (

  @SerializedName("email"   ) var email   : String?  = null,
  @SerializedName("phone"   ) var phone   : String?  = null,
  @SerializedName("address" ) var address : Address? = Address()

)