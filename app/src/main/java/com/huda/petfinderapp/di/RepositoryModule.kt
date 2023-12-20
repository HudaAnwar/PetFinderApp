package com.huda.petfinderapp.di

import com.huda.data.pet_details.PetDetailsRepoImpl
import com.huda.data.pet_details.PetDetailsServices
import com.huda.data.pet_list.PetListRepoImpl
import com.huda.data.pet_list.PetListServices
import com.huda.data.token.TokenRepoImpl
import com.huda.data.token.TokenServices
import com.huda.domain.pet_details.repository.PetDetailsRepo
import com.huda.domain.pet_list.repository.PetListRepo
import com.huda.domain.token.repository.TokenRepo
import com.huda.domain.token.requests.TokenRequest
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
        petListServices: PetListServices,tokenRequest: TokenRequest
    ): PetListRepo {
        return PetListRepoImpl(petListServices)
    }
    @Singleton
    @Provides
    fun provideTokenRepository(
        tokenServices: TokenServices,tokenRequest: TokenRequest
    ): TokenRepo {
        return TokenRepoImpl(tokenServices, tokenRequest)
    }

   @Singleton
    @Provides
   fun providePetDetailsRepository(
       petDetailsServices: PetDetailsServices,
       tokenRequest: TokenRequest
   ): PetDetailsRepo {
        return PetDetailsRepoImpl(petDetailsServices)
    }

}