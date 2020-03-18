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
        // TODO androidx.lifecycle 적용하면 원하는 액티비티나 프레그먼트의 라이프사이클에 FeedComponent 라이프사이클을 연동 할 수 있음
        feedComponent = feedComponentFactory.create()
    }

    fun release() {
        feedComponent = null
    }

    fun inflateView(parentContext: Context): View {
        val feedView = FeedView(parentContext)
        feedComponent!!.inject(feedView) // This must be called after Feed.init()
        return feedView
    }
}