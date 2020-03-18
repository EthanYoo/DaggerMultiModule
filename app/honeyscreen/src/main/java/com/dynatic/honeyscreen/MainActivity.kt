package com.dynatic.honeyscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dynatic.buzzscreen.LockerActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStartLocker.setOnClickListener {
            startActivity(Intent(this@MainActivity, LockerActivity::class.java))
        }
    }
}
