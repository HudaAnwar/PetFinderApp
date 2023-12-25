package com.huda.petfinderapp.di

import com.huda.data.pet_details.PetDetailsRepoImpl
import com.huda.data.pet_details.local.PetDetailsDao
import com.huda.data.pet_details.remote.PetDetailsServices
import com.huda.data.pet_list.PetListRepoImpl
import com.huda.data.pet_list.local.PetListDao
import com.huda.data.pet_list.local.TypesDao
import com.huda.data.pet_list.remote.PetListServices
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
        petListServices: PetListServices,
        petListDao: PetListDao,
        typesDao: TypesDao
    ): PetListRepo {
        return PetListRepoImpl(petListServices,petListDao,typesDao)
    }
    @Singleton
    @Provides
    fun provideTokenRepository(
        tokenServices: TokenServices,
        tokenRequest: TokenRequest
    ): TokenRepo {
        return TokenRepoImpl(tokenServices, tokenRequest)
    }

   @Singleton
    @Provides
   fun providePetDetailsRepository(
       petDetailsServices: PetDetailsServices,
       petDetailsDao: PetDetailsDao
   ): PetDetailsRepo {
        return PetDetailsRepoImpl(petDetailsServices,petDetailsDao)
    }

}