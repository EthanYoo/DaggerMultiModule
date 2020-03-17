package com.dynatic.feed.di

import com.dynatic.ad.di.AdComponent
import com.dynatic.feed.FeedView
import dagger.Subcomponent

@FeedScope
@Subcomponent(
    modules = [
        FeedModule::class,
        SubcomponentsModule::class
    ]
)
interface FeedComponent {

    fun inject(feedView: FeedView)

    fun adComponent(): AdComponent.Factory

    @Subcomponent.Factory
    interface Factory {
        fun create(): FeedComponent
    }
}