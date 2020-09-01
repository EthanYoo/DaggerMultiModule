package com.dynatic.feed

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.dynatic.ad.AdUseCase
import com.dynatic.daggerbase.Injections
import com.dynatic.daggerbase.qualifiers.AppId
import com.dynatic.daggerbase.qualifiers.UnitId
import com.dynatic.feed.di.FeedComponent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FeedActivity : AppCompatActivity() {

    @Inject
    @AppId
    lateinit var appId: String

    @Inject
    @UnitId
    lateinit var unitId: String

    @Inject
    lateinit var adUseCase: AdUseCase

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val injectionKey = intent.extras?.get(Injections.INJECTION_KEY) ?: throw IllegalStateException("Injection key is empty")
        val provider = Injections.providerMap[injectionKey]
        if (provider is FeedComponent.Provider) {
            provider.provideFeedComponent().inject(this)
        }

        adUseCase.loadAds()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { Log.d("FeedActivity", "appContext.loadAds().success : $it") },
                { Log.e("FeedActivity", "appContext.loadAds().error", it) }
            )

        Log.d("FeedActivity", "appId: $appId, unitId: $unitId")
    }
}