package com.finerioconnect.core.sdk.models.requests

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FCUpdateFinancialEntityRequest(
    @Json(name = "name") val name: String,
    @Json(name = "code") val code: String
)