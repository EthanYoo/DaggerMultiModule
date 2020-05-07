package com.buzzvil.buzzad_benefit.di

import android.content.Context
import com.buzzvil.buzzad_benefit.InterstitialActivity
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
    fun inject(interstitialActivity: InterstitialActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): BuzzAdBenefitComponent
    }
}