package com.huda.data.pet_list.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.huda.domain.common.models.AnimalEntity
import com.huda.domain.pet_list.models.TypeEntity

@Dao
interface TypesDao {
    @Query("SELECT * FROM types")
    suspend fun getAnimalTypes(): List<TypeEntity>?


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTypes(types: List<TypeEntity>?)

    @Query("DELETE from types")
    suspend fun deleteTypes()
}