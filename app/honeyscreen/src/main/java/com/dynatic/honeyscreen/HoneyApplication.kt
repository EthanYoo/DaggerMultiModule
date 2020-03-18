package com.dynatic.honeyscreen

import android.app.Application
import com.dynatic.buzzscreen.BuzzScreen
import com.dynatic.feed.di.FeedComponent
import com.dynatic.feed.di.FeedComponentProvider
import com.dynatic.honeyscreen.di.AppComponent
import com.dynatic.honeyscreen.di.DaggerAppComponent
import com.dynatic.lockscreen.di.LockscreenComponent
import com.dynatic.lockscreen.di.LockscreenComponentProvider

class HoneyApplication : Application(), FeedComponentProvider, LockscreenComponentProvider {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        BuzzScreen.init(applicationContext, "100000043")
    }

    override fun provideFeedComponent(): FeedComponent = appComponent.feedComponent().create()
    override fun provideLockscreenComponent(): LockscreenComponent = appComponent.lockscreenComponent().create()
}