package com.buzzvil.buzzad_benefit

import android.content.Context
import android.content.Intent
import android.util.Log
import com.buzzvil.buzzad_benefit.di.BuzzAdBenefitComponent
import com.buzzvil.buzzad_benefit.di.DaggerBuzzAdBenefitComponent
import com.dynatic.daggerbase.Injections
import com.dynatic.daggerbase.qualifiers.AppId
import com.dynatic.feed.FeedActivity
import com.dynatic.feed.di.FeedComponent
import javax.inject.Inject

class BuzzAdBenefit private constructor(context: Context, appId: String) : FeedComponent.Provider {

    private val buzzAdBenefitComponent: BuzzAdBenefitComponent = DaggerBuzzAdBenefitComponent.factory().create(context, appId)

    init {
        Injections.providerMap[this.hashCode()] = this
        buzzAdBenefitComponent.inject(this)
    }

    @Inject
    @AppId
    lateinit var appId: String

    @Inject
    lateinit var context: Context

    fun showFeed(context: Context) {
        context.startActivity(Intent(context, FeedActivity::class.java).also {
            it.putExtra(Injections.INJECTION_KEY, this.hashCode())
        })
    }

    override fun provideFeedComponent(): FeedComponent {
        val feedUnitId = "222222222222"
        return buzzAdBenefitComponent.feedComponent().create(feedUnitId)
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
            Log.d("BuzzAdBenefit", "BuzzAdBenefit is initialized")
            instance = BuzzAdBenefit(context, appId)
            return true
        }

    }
}