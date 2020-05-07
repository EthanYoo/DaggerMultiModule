package com.buzzvil.buzzad_benefit.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [BuzzAdBenefitModule::class]
)
interface BuzzAdBenefitComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): BuzzAdBenefitComponent
    }
}