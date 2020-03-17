package com.dynatic.ad

import com.dynatic.apiclient.ResponseRaw
import com.dynatic.apiclient.ad.AdServiceApi
import com.dynatic.apiclient.ad.AdsResponse
import io.reactivex.Single
import retrofit2.Response

class AdRepositoryImpl(private val adServiceApi: AdServiceApi) : AdRepository {
    override fun loadAds(): Single<Response<ResponseRaw<AdsResponse>>> {
        return adServiceApi.requestAds(mapOf())
    }
}