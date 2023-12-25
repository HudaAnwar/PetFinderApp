package com.huda.domain.common.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.huda.domain.common.MyConverter


data class Breeds (

  @SerializedName("primary"   ) var primary   : String?  = null,
  @SerializedName("secondary" ) var secondary : String?  = null,
  @SerializedName("mixed"     ) var mixed     : Boolean? = null,
  @SerializedName("unknown"   ) var unknown   : Boolean? = null

)
