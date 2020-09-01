//package com.dynatic.feed
//
//import android.annotation.SuppressLint
//import android.content.Context
//import android.util.Log
//import android.widget.LinearLayout
//import com.dynatic.ad.AdUseCase
//import com.dynatic.ad.di.AdComponent
//import io.reactivex.android.schedulers.AndroidSchedulers
//import io.reactivex.schedulers.Schedulers
//import javax.inject.Inject
//
//class FeedView(context: Context) : LinearLayout(context) {
//
//    @Inject
//    lateinit var adComponentFactory: AdComponent.Factory
//
//    @Inject
//    lateinit var appContext: Context
//
//    lateinit var adComponent: AdComponent
//
//    lateinit var adUseCase: AdUseCase
//
//    @SuppressLint("CheckResult")
//    override fun onAttachedToWindow() {
//        super.onAttachedToWindow()
//        adComponent = adComponentFactory.create()
//        adUseCase = adComponent.adUseCase()
//
//        Log.d("YYH", "adUseCase : $adUseCase")
//        Log.d("YYH", "appContext : $appContext")
//
//        adUseCase.loadAds()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                { Log.d("YYH", "appContext.loadAds() : $it") },
//                { Log.e("YYH", "", it) }
//            )
//
//    }
//}