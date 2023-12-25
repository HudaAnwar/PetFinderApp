package com.huda.domain.common.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.huda.domain.common.MyConverter


data class Links (

    @SerializedName("self"         ) var self         : Self?         = null,
    @SerializedName("type", alternate = ["breeds"]) var typeLink         : TypeLink?         = null,
    @SerializedName("organization" ) var organization : Organization? = null

)
