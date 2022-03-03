package com.finerioconnect.core.sdk.models.responses

import com.finerioconnect.core.sdk.models.FCError
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FCErrorResponse(
    @Json(name = "errors") var errors: List<FCError>
)
