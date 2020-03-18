package com.dynatic.buzzscreen

import android.content.Context
import android.util.Log

class BuzzScreen private constructor(context: Context, unitId: String) {
    companion object {
        @Volatile
        private var instance: BuzzScreen? = null

        @JvmStatic
        fun getInstance(): BuzzScreen {
            return instance ?: throw IllegalStateException("Not initialized")
        }

        @JvmStatic
        fun init(context: Context, unitId: String): Boolean {
            Log.d("YYH", "Buzzscreen is initialized")
            instance = BuzzScreen(context, unitId)
            return true
        }
    }



}