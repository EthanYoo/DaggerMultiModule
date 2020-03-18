package com.dynatic.honeyscreen

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.dynatic.feed.FeedView
import com.google.gson.Gson
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var retrofit: Retrofit

    @Inject
    lateinit var gson: Gson

    override fun onCreate(savedInstanceState: Bundle?) {

        (application as HoneyApplication).appComponent.inject(this)

        Log.d("YYH", "retrofit : $retrofit")
        Log.d("YYH", "gson : $gson")

        super.onCreate(savedInstanceState)


        setContentView(
            LinearLayout(this).apply {
                addView(FeedView(this@MainActivity))
            }
        )
    }
}
