package com.aplus.news.di

import com.aplus.news.utils.DateHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UltilityModule {

    @Provides
    @Singleton
    fun provideDateHelper() : DateHelper {
        return DateHelper()
    }
}