package com.finerioconnect.core.sdk.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FCResumeBalance(
    @Json(name = "date") val date : Int,
    @Json(name = "incomes") val incomes : Double,
    @Json(name = "expenses") val expenses : Double
)
