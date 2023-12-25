package com.huda.domain.pet_list.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.huda.domain.common.MyConverter
import com.huda.domain.common.models.Links


data class Type (

  @SerializedName("name"    ) var name    : String?           = null,
  @SerializedName("coats"   ) var coats   : ArrayList<String> = arrayListOf(),
  @SerializedName("colors"  ) var colors  : ArrayList<String> = arrayListOf(),
  @SerializedName("genders" ) var genders : ArrayList<String> = arrayListOf(),
  @SerializedName("_links"  ) var Links   : Links?            = Links()

)
@Entity("types")
@TypeConverters(MyConverter::class)
data class TypeEntity (
  @PrimaryKey(autoGenerate = true) val id       : Int?     = null,
  @ColumnInfo("name"    ) var name    : String?           = null,
  @ColumnInfo("coats"   ) var coats   : ArrayList<String> = arrayListOf(),
  @ColumnInfo("colors"  ) var colors  : ArrayList<String> = arrayListOf(),
  @ColumnInfo("genders" ) var genders : ArrayList<String> = arrayListOf(),
  @ColumnInfo("_links"  ) var Links   : Links?            = Links()

)