package com.huda.petfinderapp.di



import com.huda.data.common.RetrofitBuilder
import com.huda.data.common.SharedPreferencesManager
import com.huda.data.pet_details.PetDetailsServices
import com.huda.data.pet_list.PetListServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providePetListService(retrofit: Retrofit): PetListServices {
        return retrofit.create(PetListServices::class.java)
    }
    @Singleton
    @Provides
    fun providePetDetailsService(retrofit: Retrofit): PetDetailsServices {
        return retrofit.create(PetDetailsServices::class.java)
    }

    @Singleton
    @Provides
    private fun provideRetrofit(sharedPref: SharedPreferencesManager): Retrofit? {
        return RetrofitBuilder(sharedPref).start()
    }

}