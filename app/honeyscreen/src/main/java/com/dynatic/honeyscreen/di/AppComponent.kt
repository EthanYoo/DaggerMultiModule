package com.dynatic.honeyscreen.di

import android.content.Context
import com.dynatic.honeyscreen.MainActivity
import com.dynatic.feed.di.FeedComponent
import com.dynatic.lockscreen.di.LockscreenComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        SubcomponentsModule::class
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun feedComponent(): FeedComponent.Factory

    fun lockscreenComponent(): LockscreenComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}