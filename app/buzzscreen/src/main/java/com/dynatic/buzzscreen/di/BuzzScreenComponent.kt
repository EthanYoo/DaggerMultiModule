package com.dynatic.buzzscreen.di

import android.content.Context
import com.dynatic.buzzscreen.LockerActivity
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

    fun inject(lockerActivity: LockerActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): BuzzScreenComponent
    }
}