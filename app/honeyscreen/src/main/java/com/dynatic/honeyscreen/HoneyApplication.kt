package com.dynatic.honeyscreen

import android.app.Application
import com.dynatic.buzzscreen.BuzzScreen

class HoneyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        BuzzScreen.init(applicationContext, "100000043")
    }
}