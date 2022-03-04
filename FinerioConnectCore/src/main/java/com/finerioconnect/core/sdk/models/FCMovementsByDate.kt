package com.finerioconnect.core.sdk.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FCMovementsByDate(
    @Json(name = "date") val date : Long,
    @Json(name = "transactions") val transactions : List<FCTransaction>
)
