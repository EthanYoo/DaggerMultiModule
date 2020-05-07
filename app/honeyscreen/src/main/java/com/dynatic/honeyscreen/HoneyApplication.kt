package com.dynatic.honeyscreen

import android.app.Application
import com.buzzvil.buzzad_benefit.BuzzAdBenefit
import com.dynatic.buzzscreen.BuzzScreen

class HoneyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        BuzzScreen.init(applicationContext, "100000043")
        BuzzAdBenefit.init(applicationContext, "100000044")
    }
}