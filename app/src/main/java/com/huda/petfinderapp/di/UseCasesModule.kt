package com.huda.petfinderapp.di

import com.huda.data.pet_details.PetDetailsServices
import com.huda.data.pet_list.PetListRepoImpl
import com.huda.data.pet_list.PetListServices
import com.huda.domain.pet_details.repository.PetDetailsRepo
import com.huda.domain.pet_details.usecases.GetPetDetailsUseCase
import com.huda.domain.pet_list.repository.PetListRepo
import com.huda.domain.pet_list.usecases.GetPetsByTypeUseCase
import com.huda.domain.pet_list.usecases.GetTokenUseCase
import com.huda.domain.pet_list.usecases.GetTypesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {
    @Singleton
    @Provides
    fun provideGetTokenUseCase(petListRepo: PetListRepo): GetTokenUseCase {
        return GetTokenUseCase(petListRepo)
    }
    @Singleton
    @Provides
    fun provideGetTypesUseCase(petListRepo: PetListRepo): GetTypesUseCase {
        return GetTypesUseCase(petListRepo)
    }
    @Singleton
    @Provides
    fun provideGetPetsByTypeUseCase(petListRepo: PetListRepo): GetPetsByTypeUseCase {
        return GetPetsByTypeUseCase(petListRepo)
    }
    @Singleton
    @Provides
    fun provideGetPetDetailsUseCase(petDetailsRepo: PetDetailsRepo): GetPetDetailsUseCase {
        return GetPetDetailsUseCase(petDetailsRepo)
    }

}