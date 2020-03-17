package com.dynatic.apiclient.ad

import com.dynatic.apiclient.ResponseRaw
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface AdServiceApi {
    @GET("v3/ads")
    fun requestAds(@QueryMap requestParams: Map<String, String>): Single<Response<ResponseRaw<AdsResponse>>>
}