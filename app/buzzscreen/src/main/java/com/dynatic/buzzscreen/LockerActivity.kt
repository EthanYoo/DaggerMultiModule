package com.dynatic.buzzscreen

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.dynatic.feed.Feed
import com.dynatic.lockscreen.Lockscreen
import com.google.gson.Gson
import retrofit2.Retrofit
import javax.inject.Inject

class LockerActivity : AppCompatActivity() {

    @Inject
    lateinit var retrofit: Retrofit

    @Inject
    lateinit var gson: Gson

    @Inject
    lateinit var feed: Feed

    @Inject
    lateinit var lockscreen: Lockscreen

    override fun onCreate(savedInstanceState: Bundle?) {
        BuzzScreen.getInstance().buzzScreenComponent.inject(this)

        super.onCreate(savedInstanceState)
        
        feed.init()
        lockscreen.init()

        setContentView(
            LinearLayout(this).apply {
                addView(feed.inflateView(this@LockerActivity))
            }
        )
    }

    override fun onDestroy() {

        feed.release()
        lockscreen.release()

        super.onDestroy()
    }
}
