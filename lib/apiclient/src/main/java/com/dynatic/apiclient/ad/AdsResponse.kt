package com.dynatic.apiclient.ad

import com.dynatic.apiclient.ad.AdEntity
import com.google.gson.annotations.SerializedName

data class AdsResponse(
    @SerializedName("ads")
    var ads: Collection<AdEntity>?,
    @SerializedName("cursor")
    var pagingKey: String?
)
