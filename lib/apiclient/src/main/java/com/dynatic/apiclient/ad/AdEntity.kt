package com.dynatic.apiclient.ad

import com.google.gson.annotations.SerializedName

data class AdEntity constructor(
    @SerializedName("id")
    val id: Int,
    @SerializedName("creative")
    val rawCreative: Map<String, Any>? = null,
    @SerializedName("call_to_action")
    val callToAction: String? = null,
    @SerializedName("click_trackers")
    val clickTrackers: List<String>? = null,
    @SerializedName("fail_trackers")
    val failTrackers: List<String>? = null,
    @SerializedName("impression_trackers")
    val impressionTrackers: List<String>? = null,
    @SerializedName("revenue_type")
    val revenueType: String? = null,
    @SerializedName("payload")
    val payload: String? = null,
    @SerializedName("extra")
    val extra: Map<String, String>? = null,
    @SerializedName("landing_type")
    val landingType: Int = 0,
    @SerializedName("action_reward")
    val actionReward: Int = 0,
    @SerializedName("landing_reward")
    val landingReward: Int = 0,
    @SerializedName("meta")
    val meta: Map<String, String>? = null,
    @SerializedName("network")
    val network: String? = null,
    @SerializedName("ttl")
    val ttl: Int = 0,
    @SerializedName("unlock_reward")
    val unlockReward: Int = 0,
    @SerializedName("ad_report_data")
    val adReportData: String? = null,
    @SerializedName("reward_status")
    val rewardStatus: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("integration_type")
    val integrationType: String? = null,
    @SerializedName("preferred_browser")
    val preferredBrowser: String? = null
)
