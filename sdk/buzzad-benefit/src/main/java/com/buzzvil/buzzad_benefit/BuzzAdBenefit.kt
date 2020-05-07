package com.buzzvil.buzzad_benefit

import android.content.Context
import android.util.Log
import com.buzzvil.buzzad_benefit.di.BuzzAdBenefitComponent
import com.buzzvil.buzzad_benefit.di.DaggerBuzzAdBenefitComponent

class BuzzAdBenefit private constructor(private val context: Context, private val appId: String) {

    val buzzAdBenefitComponent: BuzzAdBenefitComponent by lazy {
        DaggerBuzzAdBenefitComponent.factory().create(context)
    }

    companion object {
        @Volatile
        private var instance: BuzzAdBenefit? = null

        @JvmStatic
        fun getInstance(): BuzzAdBenefit {
            return instance ?: throw IllegalStateException("Not initialized")
        }

        @JvmStatic
        fun init(context: Context, appId: String): Boolean {
            Log.d("YYH", "BuzzAdBenefit is initialized")
            instance = BuzzAdBenefit(context, appId)
            return true
        }
    }
}