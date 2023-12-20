package com.huda.petfinderapp.di

import android.content.Context
import android.content.SharedPreferences
import com.huda.data.common.SharedPreferencesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object SharedPrefModule {

    @Provides
    @ActivityScoped
    fun provideSharedPref(@ActivityContext context: Context): SharedPreferences? {
        return context.getSharedPreferences("PetFinderApp",Context.MODE_PRIVATE)
    }
    @Provides
    @ActivityScoped
    fun provideSharedPrefManager(sharedPreferences: SharedPreferences): SharedPreferencesManager {
        return SharedPreferencesManager(sharedPreferences)
    }

}