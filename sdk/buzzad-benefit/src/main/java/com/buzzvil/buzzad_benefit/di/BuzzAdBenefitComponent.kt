package com.buzzvil.buzzad_benefit.di

import android.content.Context
import com.buzzvil.buzzad_benefit.BuzzAdBenefit
import com.dynatic.daggerbase.qualifiers.AppId
import com.dynatic.feed.di.FeedComponent
import dagger.BindsInstance
import dagger.Component

@BuzzAdBenefitScope
@Component(
    modules = [
        BuzzAdBenefitModule::class,
        SubcomponentsModule::class
    ]
)
interface BuzzAdBenefitComponent {
    fun inject(buzzAdBenefit: BuzzAdBenefit)

    fun feedComponent(): FeedComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            @BindsInstance @AppId appId: String
        ): BuzzAdBenefitComponent
    }
}