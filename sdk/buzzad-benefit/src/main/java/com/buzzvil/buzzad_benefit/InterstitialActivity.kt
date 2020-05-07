package com.buzzvil.buzzad_benefit

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.dynatic.feed.Feed
import javax.inject.Inject

class InterstitialActivity : AppCompatActivity() {

    @Inject
    lateinit var feed: Feed

    override fun onCreate(savedInstanceState: Bundle?) {
        BuzzAdBenefit.getInstance().buzzAdBenefitComponent.inject(this)

        super.onCreate(savedInstanceState)

        feed.init()

        setContentView(
            LinearLayout(this).apply {
                addView(feed.inflateView(this@InterstitialActivity))
            }
        )
    }

    override fun onDestroy() {
        feed.release()

        super.onDestroy()
    }
}