package com.dynatic.apiclient

import com.google.gson.annotations.SerializedName

data class ResponseRaw<T>(
    @SerializedName("message")
    var message: String?,
    @SerializedName("code")
    var code: Int,
    @SerializedName("result")
    var result: T
)
