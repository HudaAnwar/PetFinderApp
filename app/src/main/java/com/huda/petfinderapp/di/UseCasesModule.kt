package com.huda.petfinderapp.di

import com.huda.domain.pet_details.repository.PetDetailsRepo
import com.huda.domain.pet_details.usecases.FetchPetDetailsUseCase
import com.huda.domain.pet_details.usecases.GetPetDetailsUseCase
import com.huda.domain.pet_list.repository.PetListRepo
import com.huda.domain.pet_list.usecases.FetchPetsByTypeUseCase
import com.huda.domain.pet_list.usecases.FetchTypesUseCase
import com.huda.domain.pet_list.usecases.GetPetsByTypeUseCase
import com.huda.domain.pet_list.usecases.GetTypesUseCase
import com.huda.domain.token.repository.TokenRepo
import com.huda.domain.token.usecases.GetTokenUseCase
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
    fun provideGetTokenUseCase(tokenRepo: TokenRepo): GetTokenUseCase {
        return GetTokenUseCase(tokenRepo)
    }
    @Singleton
    @Provides
    fun provideGetTypesUseCase(petListRepo: PetListRepo): GetTypesUseCase {
        return GetTypesUseCase(petListRepo)
    }
    @Singleton
    @Provides
    fun provideFetchTypesUseCase(petListRepo: PetListRepo): FetchTypesUseCase {
        return FetchTypesUseCase(petListRepo)
    }
    @Singleton
    @Provides
    fun provideGetPetsByTypeUseCase(petListRepo: PetListRepo): GetPetsByTypeUseCase {
        return GetPetsByTypeUseCase(petListRepo)
    }
    @Singleton
    @Provides
    fun provideFetchPetsByTypeUseCase(petListRepo: PetListRepo): FetchPetsByTypeUseCase {
        return FetchPetsByTypeUseCase(petListRepo)
    }
    @Singleton
    @Provides
    fun provideGetPetDetailsUseCase(petDetailsRepo: PetDetailsRepo): GetPetDetailsUseCase {
        return GetPetDetailsUseCase(petDetailsRepo)
    }
    @Singleton
    @Provides
    fun provideFetchPetDetailsUseCase(petDetailsRepo: PetDetailsRepo): FetchPetDetailsUseCase {
        return FetchPetDetailsUseCase(petDetailsRepo)
    }

}