package com.dynatic.lockscreen

import android.content.Context
import android.util.Log
import android.widget.LinearLayout
import com.dynatic.auth.Auth
import javax.inject.Inject

class LockscreenView(context: Context) : LinearLayout(context) {

    @Inject
    lateinit var auth: Auth

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.d("YYH", "auth: $auth")
    }
}