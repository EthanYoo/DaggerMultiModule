package com.dynatic.apiclient.di

import com.dynatic.apiclient.ad.AdServiceApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object ApiClientModule {

    @Provides
    fun provideAdServiceApi(retrofit: Retrofit): AdServiceApi = retrofit.create(AdServiceApi::class.java)
}