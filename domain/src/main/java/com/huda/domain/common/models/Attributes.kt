package com.huda.domain.common.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.huda.domain.common.MyConverter


data class Attributes (

  @SerializedName("spayed_neutered" ) var spayedNeutered : Boolean? = null,
  @SerializedName("house_trained"   ) var houseTrained   : Boolean? = null,
  @SerializedName("declawed"        ) var declawed       : Boolean? = null,
  @SerializedName("special_needs"   ) var specialNeeds   : Boolean? = null,
  @SerializedName("shots_current"   ) var shotsCurrent   : Boolean? = null

)
