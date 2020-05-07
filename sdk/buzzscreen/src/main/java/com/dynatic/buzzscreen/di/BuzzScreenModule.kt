package com.dynatic.buzzscreen.di

import com.dynatic.feed.Feed
import com.dynatic.feed.di.FeedComponent
import com.dynatic.lockscreen.Lockscreen
import com.dynatic.lockscreen.di.LockscreenComponent
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

@Module
object BuzzScreenModule {
    @BuzzScreenScope
    @Provides
    fun provideGson(): Gson = Gson()

    @BuzzScreenScope
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://screen.buzzvil.com/api/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @BuzzScreenScope
    @Provides
    fun provideFeed(feedComponentFactory: FeedComponent.Factory): Feed = Feed(feedComponentFactory)

    @BuzzScreenScope
    @Provides
    fun provideLockscreen(lockscreenComponentFactory: LockscreenComponent.Factory): Lockscreen = Lockscreen(lockscreenComponentFactory)
}