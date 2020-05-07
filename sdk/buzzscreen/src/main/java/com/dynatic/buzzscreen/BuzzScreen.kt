package com.dynatic.buzzscreen

import android.content.Context
import android.util.Log
import com.dynatic.buzzscreen.di.BuzzScreenComponent
import com.dynatic.buzzscreen.di.DaggerBuzzScreenComponent

class BuzzScreen private constructor(private val context: Context, private val appId: String) {

    val buzzScreenComponent: BuzzScreenComponent by lazy {
        DaggerBuzzScreenComponent.factory().create(context)
    }

    companion object {
        @Volatile
        private var instance: BuzzScreen? = null

        @JvmStatic
        fun getInstance(): BuzzScreen {
            return instance ?: throw IllegalStateException("Not initialized")
        }

        @JvmStatic
        fun init(context: Context, appId: String): Boolean {
            Log.d("YYH", "Buzzscreen is initialized")
            instance = BuzzScreen(context, appId)
            return true
        }
    }
}