package com.dynatic.buzzscreen.di

import com.dynatic.feed.di.FeedComponent
import com.dynatic.lockscreen.di.LockscreenComponent
import dagger.Module

@Module(
    subcomponents = [
        FeedComponent::class,
        LockscreenComponent::class
    ]
)
object SubcomponentsModule