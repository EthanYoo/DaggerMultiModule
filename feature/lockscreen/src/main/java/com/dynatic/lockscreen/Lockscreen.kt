package com.dynatic.lockscreen

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.dynatic.lockscreen.di.LockscreenComponent
import javax.inject.Inject

class Lockscreen @Inject constructor(
    private val lockscreenComponentFactory: LockscreenComponent.Factory
) {

    private var lockscreenComponent: LockscreenComponent? = null

    fun init() {
        lockscreenComponent = lockscreenComponentFactory.create()
    }

    fun release() {
        lockscreenComponent = null
    }

    fun inflateView(parentContext: Context): View {
        return LinearLayout(parentContext)
    }
}