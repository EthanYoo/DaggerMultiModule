package com.dynatic.honeyscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.buzzvil.buzzad_benefit.BuzzAdBenefit
import com.dynatic.buzzscreen.BuzzScreen
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStartLocker.setOnClickListener {
            BuzzScreen.getInstance().showLocker(this)
        }

        btnStartFeed.setOnClickListener {
            BuzzAdBenefit.getInstance().showFeed(this)
        }
    }
}
