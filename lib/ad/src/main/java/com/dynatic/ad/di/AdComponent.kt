package com.dynatic.ad.di

import com.dynatic.ad.AdUseCase
import dagger.Subcomponent

@AdScope
@Subcomponent(
    modules = [
        AdModule::class
    ]
)
interface AdComponent {

    fun adUseCase(): AdUseCase

    @Subcomponent.Factory
    interface Factory {
        fun create(): AdComponent
    }
}