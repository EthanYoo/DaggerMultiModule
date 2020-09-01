package com.dynatic.ad.di

import com.dynatic.ad.AdRepository
import com.dynatic.ad.AdRepositoryImpl
import com.dynatic.apiclient.ad.AdServiceApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [AdModule.AdBindModule::class])
object AdModule {

    @Provides
    fun provideAdServiceApi(retrofit: Retrofit): AdServiceApi = retrofit.create(AdServiceApi::class.java)

    @Module
    abstract class AdBindModule {
        @Binds
        abstract fun bindAdRepository(adRepositoryImpl: AdRepositoryImpl): AdRepository
    }
}