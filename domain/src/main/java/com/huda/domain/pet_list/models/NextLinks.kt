package com.huda.domain.pet_list.models

import com.google.gson.annotations.SerializedName
import com.huda.domain.pet_list.models.Next

data class NextLinks (

    @SerializedName("next" ) var next : Next? = Next()

)