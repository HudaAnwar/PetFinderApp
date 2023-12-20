package com.huda.petfinderapp.di

import android.content.Context
import android.content.SharedPreferences
import com.huda.data.common.SharedPreferencesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPrefModule {

    @Provides
    @Singleton
    fun provideSharedPref(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("PetFinderApp",Context.MODE_PRIVATE)
    }
    @Provides
    @Singleton
    fun provideSharedPrefManager(sharedPreferences: SharedPreferences): SharedPreferencesManager {
        return SharedPreferencesManager(sharedPreferences)
    }

}