package com.huda.petfinderapp.di



import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import com.huda.data.common.RetrofitBuilder
import com.huda.data.common.SharedPreferencesManager
import com.huda.data.pet_details.PetDetailsServices
import com.huda.data.pet_list.PetListServices
import com.huda.domain.pet_list.requests.TokenRequest
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
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
    fun provideRetrofit(sharedPref: SharedPreferencesManager): Retrofit {
        return RetrofitBuilder(sharedPref).start()
    }
    @Singleton
    @Provides
    fun provideTokenRequest(@ApplicationContext context: Context): TokenRequest {
        val ai: ApplicationInfo = context.packageManager
            .getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)
        val clientId = ai.metaData["client_id"].toString()
        val clientSecret = ai.metaData["client_secret"].toString()
        return TokenRequest(
            "client_credentials",
            clientId, clientSecret
        )
    }

}