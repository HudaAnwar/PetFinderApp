package com.huda.data.pet_list.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.huda.domain.common.models.AnimalEntity

@Dao
interface PetListDao {
    @Query("SELECT * FROM animal  WHERE (:animalType IS NULL OR type = :animalType)")
    suspend fun fetchPetsByType(animalType: String? = null): List<AnimalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPets(pets: List<AnimalEntity>)

    @Query("DELETE from animal")
    suspend fun deleteAnimals()
}