package com.dynatic.feed.di

import com.dynatic.ad.di.AdModule
import com.dynatic.daggerbase.qualifiers.UnitId
import com.dynatic.feed.FeedActivity
import dagger.BindsInstance
import dagger.Subcomponent

@FeedScope
@Subcomponent(
    modules = [
        FeedModule::class,
        AdModule::class
    ]
)
interface FeedComponent {

    fun inject(feedActivity: FeedActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance @UnitId unitId: String
        ): FeedComponent
    }

    interface Provider {
        fun provideFeedComponent(): FeedComponent
    }
}