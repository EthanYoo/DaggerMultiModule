package com.dynatic.ad

import com.dynatic.apiclient.ResponseRaw
import com.dynatic.apiclient.ad.AdsResponse
import io.reactivex.Single
import retrofit2.Response

interface AdRepository {
    fun loadAds(): Single<Response<ResponseRaw<AdsResponse>>>
}