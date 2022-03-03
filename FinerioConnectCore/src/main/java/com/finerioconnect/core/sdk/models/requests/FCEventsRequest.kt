package com.finerioconnect.core.sdk.models.requests

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FCEventsRequest(
    @Json(name = "deviceId")
    val deviceId: String,
    @Json(name = "event")
    val event: String
)