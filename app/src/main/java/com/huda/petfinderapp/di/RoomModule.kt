package com.huda.petfinderapp.di

import android.content.Context
import androidx.room.Room
import com.huda.data.common.AppDatabase
import com.huda.data.pet_details.local.PetDetailsDao
import com.huda.data.pet_list.local.PetListDao
import com.huda.data.pet_list.local.TypesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "myApp_db"
        ).build()
    }
    @Provides
    @Singleton
    fun providePetListDao(database: AppDatabase): PetListDao {
        return database.getPetListDao()
    }
    @Provides
    @Singleton
    fun providePetDetailsDao(database: AppDatabase): PetDetailsDao {
        return database.getPetDetailsDao()
    }
    @Provides
    @Singleton
    fun provideTypesDao(database: AppDatabase): TypesDao {
        return database.getTypesDao()
    }
}