package com.dynatic.lockscreen

import android.content.Context
import android.widget.LinearLayout
import com.dynatic.lockscreen.di.LockscreenComponent
import com.dynatic.lockscreen.di.LockscreenComponentProvider

class LockscreenView(context: Context) : LinearLayout(context) {

    private lateinit var lockscreenComponent: LockscreenComponent

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        lockscreenComponent = (context.applicationContext as LockscreenComponentProvider).provideLockscreenComponent()
        lockscreenComponent.inject(this)
    }
}