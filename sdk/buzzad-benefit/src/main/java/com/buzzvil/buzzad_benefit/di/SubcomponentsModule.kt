package com.buzzvil.buzzad_benefit.di

import com.dynatic.feed.di.FeedComponent
import com.dynatic.lockscreen.di.LockscreenComponent
import dagger.Module

@Module(
    subcomponents = [
        FeedComponent::class
    ]
)
object SubcomponentsModule