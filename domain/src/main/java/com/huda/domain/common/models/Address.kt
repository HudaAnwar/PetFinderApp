package com.huda.domain.common.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class Address (

  @SerializedName("address1" ) var address1 : String? = null,
  @SerializedName("address2" ) var address2 : String? = null,
  @SerializedName("city"     ) var city     : String? = "NA",
  @SerializedName("state"    ) var state    : String? = "NA",
  @SerializedName("postcode" ) var postcode : String? = null,
  @SerializedName("country"  ) var country  : String? = "NA"

)