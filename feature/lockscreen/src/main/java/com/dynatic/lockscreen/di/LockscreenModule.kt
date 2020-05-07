package com.dynatic.lockscreen.di

import android.content.Context
import com.dynatic.auth.Auth
import dagger.Module
import dagger.Provides

@Module
object LockscreenModule {
    @Provides
    fun provideAuth(context: Context) = Auth(context)
}