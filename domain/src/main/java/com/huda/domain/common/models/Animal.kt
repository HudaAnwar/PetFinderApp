package com.huda.domain.common.models

import com.google.gson.annotations.SerializedName


data class Animal (

  @SerializedName("id"                     ) var id                   : Int?                 = null,
  @SerializedName("organization_id"        ) var organizationId       : String?              = null,
  @SerializedName("url"                    ) var url                  : String?              = null,
  @SerializedName("type"                   ) var type                 : String?              = null,
  @SerializedName("species"                ) var species              : String?              = null,
  @SerializedName("breeds"                 ) var breeds               : Breeds?              = Breeds(),
  @SerializedName("colors"                 ) var colors               : Colors?              = Colors(),
  @SerializedName("age"                    ) var age                  : String?              = null,
  @SerializedName("gender"                 ) var gender               : String?              = null,
  @SerializedName("size"                   ) var size                 : String?              = null,
  @SerializedName("coat"                   ) var coat                 : String?              = null,
  @SerializedName("attributes"             ) var attributes           : Attributes?          = Attributes(),
  @SerializedName("environment"            ) var environment          : Environment?         = Environment(),
  @SerializedName("tags"                   ) var tags                 : ArrayList<String>    = arrayListOf(),
  @SerializedName("name"                   ) var name                 : String?              = null,
  @SerializedName("description"            ) var description          : String?              = null,
  @SerializedName("organization_animal_id" ) var organizationAnimalId : String?              = null,
  @SerializedName("photos"                 ) var photos               : ArrayList<Photos>    = arrayListOf(),
  @SerializedName("primary_photo_cropped"  ) var primaryPhotoCropped  : PrimaryPhotoCropped? = PrimaryPhotoCropped(),
  @SerializedName("videos"                 ) var videos               : ArrayList<Any>    = arrayListOf(),
  @SerializedName("status"                 ) var status               : String?              = null,
  @SerializedName("status_changed_at"      ) var statusChangedAt      : String?              = null,
  @SerializedName("published_at"           ) var publishedAt          : String?              = null,
  @SerializedName("distance"               ) var distance             : String?              = null,
  @SerializedName("contact"                ) var contact              : Contact?             = Contact(),
  @SerializedName("_links"                 ) var Links                : Links?               = Links(),

  )