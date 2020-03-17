package com.dynatic.feed

import android.content.Context
import android.util.Log
import android.widget.LinearLayout
import com.dynatic.ad.AdUseCase
import com.dynatic.ad.di.AdComponent
import com.dynatic.feed.di.FeedComponent
import com.dynatic.feed.di.FeedComponentProvider

class FeedView(context: Context) : LinearLayout(context) {

    private lateinit var feedComponent: FeedComponent

    lateinit var adComponent: AdComponent
    lateinit var adUseCase: AdUseCase

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        feedComponent = (context.applicationContext as FeedComponentProvider).provideFeedComponent()
        feedComponent.inject(this)

        adComponent = feedComponent.adComponent().create()
        adUseCase = adComponent.adUseCase()

        Log.d("YYH", "adUseCase : $adUseCase")
    }
}