package com.huda.domain.common.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Junction
import androidx.room.PrimaryKey
import androidx.room.Relation
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.huda.domain.common.MyConverter


data class Animal (

  @SerializedName("id"                     ) var id                   : Int?                 = null,
  @SerializedName("organization_id"        ) var organizationId       : String?              = null,
  @SerializedName("url"                    ) var url                  : String?              = null,
  @SerializedName("type"                   ) var type                 : String?              = null,
  @SerializedName("species"                ) var species              : String?              = null,
  @SerializedName("breeds"                 ) var breeds               : Breeds?              = null,
  @SerializedName("colors"                 ) var colors               : Colors?              = null,
  @SerializedName("age"                    ) var age                  : String?              = null,
  @SerializedName("gender"                 ) var gender               : String?              = null,
  @SerializedName("size"                   ) var size                 : String?              = null,
  @SerializedName("coat"                   ) var coat                 : String?              = null,
  @SerializedName("attributes"             ) var attributes           : Attributes?          = null,
  @SerializedName("environment"            ) var environment          : Environment?         = null,
  @SerializedName("tags"                   ) var tags                 : ArrayList<String> ?  = null,
  @SerializedName("name"                   ) var name                 : String?              = null,
  @SerializedName("description"            ) var description          : String?              = null,
  @SerializedName("organization_animal_id" ) var organizationAnimalId : String?              = null,
  @SerializedName("photos"                 ) var photos               : ArrayList<Photos>?   = null,
  @SerializedName("primary_photo_cropped"  ) var primaryPhotoCropped  : PrimaryPhotoCropped? = null,
  @SerializedName("videos"                 ) var videos               : ArrayList<Any>?      = null,
  @SerializedName("status"                 ) var status               : String?              = null,
  @SerializedName("status_changed_at"      ) var statusChangedAt      : String?              = null,
  @SerializedName("published_at"           ) var publishedAt          : String?              = null,
  @SerializedName("distance"               ) var distance             : String?              = null,
  @SerializedName("contact"                ) var contact              : Contact?             = null,
  @SerializedName("_links"                 ) var Links                : Links?               = null,

  )

@Entity(tableName = "animal")
@TypeConverters(MyConverter::class)
data class AnimalEntity (

  @PrimaryKey var id: Int? = null,
  @ColumnInfo("organization_id"        ) var organizationId       : String?              = null,
  @ColumnInfo("url"                    ) var url                  : String?              = null,
  @ColumnInfo("type"                   ) var type                 : String?              = null,
  @ColumnInfo("species"                ) var species              : String?              = null,
  @ColumnInfo("breeds"                 ) var breeds               : Breeds?        = null,
  @ColumnInfo("colors"                 ) var colors               : Colors?              = null,
  @ColumnInfo("age"                    ) var age                  : String?              = null,
  @ColumnInfo("gender"                 ) var gender               : String?              = null,
  @ColumnInfo("size"                   ) var size                 : String?              = null,
  @ColumnInfo("coat"                   ) var coat                 : String?              = null,
  @ColumnInfo("attributes"             ) var attributes           : Attributes?          = null,
  @ColumnInfo("environment"            ) var environment          : Environment?         = null,
  @ColumnInfo("tags"                   ) var tags                 : ArrayList<String>?    = null,
  @ColumnInfo("name"                   ) var name                 : String?              = null,
  @ColumnInfo("description"            ) var description          : String?              = null,
  @ColumnInfo("organization_animal_id" ) var organizationAnimalId : String?              = null,
  @ColumnInfo("photos"                 ) var photos               : ArrayList<Photos>?    = null,
  @ColumnInfo("primary_photo_cropped"  ) var primaryPhotoCropped  : PrimaryPhotoCropped? = null,
  @ColumnInfo("status"                 ) var status               : String?              = null,
  @ColumnInfo("status_changed_at"      ) var statusChangedAt      : String?              = null,
  @ColumnInfo("published_at"           ) var publishedAt          : String?              = null,
  @ColumnInfo("distance"               ) var distance             : String?              = null,
  @ColumnInfo("contact"                ) var contact              : Contact?             = null,
  @ColumnInfo("_links"                 ) var Links                : Links?               = null,

  )
