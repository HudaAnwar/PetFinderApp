package com.huda.domain.common.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.huda.domain.common.MyConverter


data class Environment (

  @SerializedName("children" ) var children : String?  = null,
  @SerializedName("dogs"     ) var dogs     : String?  = null,
  @SerializedName("cats"     ) var cats     : Boolean? = null

)
