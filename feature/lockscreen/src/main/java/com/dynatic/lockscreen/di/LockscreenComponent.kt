package com.dynatic.lockscreen.di

import com.dynatic.lockscreen.LockscreenView
import dagger.Subcomponent

@LockscreenScope
@Subcomponent(
    modules = [
        LockscreenModule::class
    ]
)
interface LockscreenComponent {
    fun inject(lockscreenView: LockscreenView)

    @Subcomponent.Factory
    interface Factory {
        fun create(): LockscreenComponent
    }
}