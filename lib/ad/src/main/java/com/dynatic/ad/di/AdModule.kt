package com.dynatic.ad.di

import com.dynatic.ad.AdRepository
import com.dynatic.ad.AdRepositoryImpl
import dagger.Binds
import dagger.Module

@Module(includes = [AdModule.AdBindModule::class])
object AdModule {

    @Module
    abstract class AdBindModule {
        @Binds
        abstract fun bindAdRepository(adRepositoryImpl: AdRepositoryImpl): AdRepository
    }
}