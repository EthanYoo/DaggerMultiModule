package com.dynatic.feed

import android.content.Context
import android.view.View
import com.dynatic.feed.di.FeedComponent
import javax.inject.Inject

class Feed @Inject constructor(
    private val feedComponentFactory: FeedComponent.Factory
) {
    private var feedComponent: FeedComponent? = null

    fun init() {
        feedComponent = feedComponentFactory.create()
    }

    fun release() {
        feedComponent = null
    }

    fun inflateView(parentContext: Context): View {
        // TODO Component Architecture 적용하는 것이 더 좋은 구조를 가져갈 수 있을 것 같음
        val feedView = FeedView(parentContext)
        feedComponent!!.inject(feedView) // This must be called after Feed.init()
        return feedView
    }
}