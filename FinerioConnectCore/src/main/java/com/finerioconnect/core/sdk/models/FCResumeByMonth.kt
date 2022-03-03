package com.finerioconnect.core.sdk.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FCResumeByMonth(
    @Json(name = "date") val date : Int,
    @Json(name = "amount") val amount : Double,
    @Json(name = "categories") val categories : List<FCResumeByCategory>
)
