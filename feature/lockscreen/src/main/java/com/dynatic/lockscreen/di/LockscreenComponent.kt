package com.dynatic.lockscreen.di

import com.dynatic.daggerbase.qualifiers.UnitId
import com.dynatic.lockscreen.LockerActivity
import dagger.BindsInstance
import dagger.Subcomponent

@LockscreenScope
@Subcomponent(
    modules = [
        LockscreenModule::class,
        SubcomponentsModule::class
    ]
)
interface LockscreenComponent {

    fun inject(lockerActivity: LockerActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance @UnitId unitId: String
        ): LockscreenComponent
    }

    interface Provider {
        fun provideLockscreenComponent(): LockscreenComponent
    }
}