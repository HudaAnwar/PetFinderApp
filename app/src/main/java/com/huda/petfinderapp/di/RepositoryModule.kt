package com.huda.petfinderapp.di

import com.huda.data.pet_details.PetDetailsRepoImpl
import com.huda.data.pet_details.PetDetailsServices
import com.huda.data.pet_list.PetListRepoImpl
import com.huda.data.pet_list.PetListServices
import com.huda.domain.pet_details.repository.PetDetailsRepo
import com.huda.domain.pet_list.repository.PetListRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun providePetListRepository(
        petListServices: PetListServices): PetListRepo {
        return PetListRepoImpl(petListServices)
    }

   @Singleton
    @Provides
    fun providePetDetailsRepository(petDetailsServices: PetDetailsServices): PetDetailsRepo {
        return PetDetailsRepoImpl(petDetailsServices)
    }

}