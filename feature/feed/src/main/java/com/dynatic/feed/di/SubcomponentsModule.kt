package com.dynatic.feed.di

import com.dynatic.ad.di.AdComponent
import dagger.Module

@Module(
    subcomponents = [
        AdComponent::class
    ]
)
object SubcomponentsModule {
}