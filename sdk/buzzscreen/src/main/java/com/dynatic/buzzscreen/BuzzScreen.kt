package com.dynatic.buzzscreen

import android.content.Context
import android.content.Intent
import android.util.Log
import com.dynatic.buzzscreen.di.BuzzScreenComponent
import com.dynatic.buzzscreen.di.DaggerBuzzScreenComponent
import com.dynatic.daggerbase.Injections
import com.dynatic.daggerbase.qualifiers.AppId
import com.dynatic.lockscreen.LockerActivity
import com.dynatic.lockscreen.di.LockscreenComponent
import javax.inject.Inject

class BuzzScreen private constructor(context: Context, appId: String) : LockscreenComponent.Provider {

    private val buzzScreenComponent: BuzzScreenComponent = DaggerBuzzScreenComponent.factory().create(context, appId)

    init {
        Injections.providerMap[this.hashCode()] = this
        buzzScreenComponent.inject(this)
    }

    @Inject
    @AppId
    lateinit var appId: String

    @Inject
    lateinit var context: Context

    fun showLocker(context: Context) {
        context.startActivity(Intent(context, LockerActivity::class.java).also {
            it.putExtra(Injections.INJECTION_KEY, this.hashCode())
        })
    }

    override fun provideLockscreenComponent(): LockscreenComponent {
        val lockscreenUnitId = "1111111111111"
        return buzzScreenComponent.lockscreenComponent().create(lockscreenUnitId)
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
            Log.d("BuzzScreen", "Buzzscreen is initialized")
            instance = BuzzScreen(context, appId)
            return true
        }

    }

}