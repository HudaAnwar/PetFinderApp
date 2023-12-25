package com.huda.data.common

import androidx.room.Database
import androidx.room.RoomDatabase
import com.huda.data.pet_details.local.PetDetailsDao
import com.huda.data.pet_list.local.PetListDao
import com.huda.data.pet_list.local.TypesDao
import com.huda.domain.common.models.AnimalEntity
import com.huda.domain.pet_list.models.TypeEntity

@Database(entities = [AnimalEntity::class, TypeEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase:RoomDatabase() {
    abstract fun getPetListDao():PetListDao
    abstract fun getPetDetailsDao():PetDetailsDao
    abstract fun getTypesDao():TypesDao
}