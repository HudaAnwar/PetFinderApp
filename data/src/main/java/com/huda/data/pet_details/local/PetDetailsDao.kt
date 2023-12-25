package com.huda.data.pet_details.local

import androidx.room.Dao
import androidx.room.Query
import com.huda.domain.common.models.AnimalEntity

@Dao
interface PetDetailsDao {
    @Query("SELECT *  from animal where id=:petId")
    suspend fun getPetById(petId:Int):AnimalEntity?
}