package com.dynatic.feed

import android.content.Context
import android.widget.LinearLayout
import com.dynatic.feed.di.FeedComponent
import com.dynatic.feed.di.FeedComponentProvider

class FeedView(context: Context) : LinearLayout(context) {

    private lateinit var feedComponent: FeedComponent

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        feedComponent = (context.applicationContext as FeedComponentProvider).provideFeedComponent()
        feedComponent.inject(this)
    }
}