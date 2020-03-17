package com.dynatic.apiclient.ad

import com.google.gson.annotations.SerializedName

data class AdsResponse(
    @SerializedName("ads")
    var ads: Collection<AdEntity>?,
    @SerializedName("cursor")
    var pagingKey: String?
)
