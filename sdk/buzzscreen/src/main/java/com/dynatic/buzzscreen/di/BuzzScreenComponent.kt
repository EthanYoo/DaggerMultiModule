package com.dynatic.buzzscreen.di

import android.content.Context
import com.dynatic.buzzscreen.BuzzScreen
import com.dynatic.daggerbase.qualifiers.AppId
import com.dynatic.feed.di.FeedComponent
import com.dynatic.lockscreen.di.LockscreenComponent
import dagger.BindsInstance
import dagger.Component

@BuzzScreenScope
@Component(
    modules = [
        BuzzScreenModule::class,
        SubcomponentsModule::class
    ]
)
interface BuzzScreenComponent {

    fun inject(buzzScreen: BuzzScreen)

    fun lockscreenComponent(): LockscreenComponent.Factory

    fun feedComponent(): FeedComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            @BindsInstance @AppId appId: String
        ): BuzzScreenComponent
    }
}