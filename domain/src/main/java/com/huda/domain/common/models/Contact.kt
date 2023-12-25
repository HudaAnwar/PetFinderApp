package com.huda.domain.common.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.huda.domain.common.MyConverter


data class Contact (

  @SerializedName("email"   ) var email   : String?  = null,
  @SerializedName("phone"   ) var phone   : String?  = null,
  @SerializedName("address" ) var address : Address? = Address()

)
