package com.dynatic.lockscreen

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.dynatic.daggerbase.Injections
import com.dynatic.daggerbase.qualifiers.AppId
import com.dynatic.daggerbase.qualifiers.UnitId
import com.dynatic.lockscreen.di.LockscreenComponent
import javax.inject.Inject

class LockerActivity : AppCompatActivity() {

    @Inject
    @AppId
    lateinit var appId: String

    @Inject
    @UnitId
    lateinit var unitId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val injectionKey = intent.extras?.get(Injections.INJECTION_KEY) ?: throw IllegalStateException("Injection key is empty")
        val provider = Injections.providerMap[injectionKey]
        if (provider is LockscreenComponent.Provider) {
            provider.provideLockscreenComponent().inject(this)
        }

        Log.d("LockerActivity", "appId: $appId, unitId: $unitId")
    }
}
