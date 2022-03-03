package com.finerioconnect.core.sdk.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FCFinancialEntity(
    @Json(name = "id") val id : Int,
    @Json(name = "name") val name : String,
    @Json(name = "code") val code : String,
    @Json(name = "dateCreated") val dateCreated : Long,
    @Json(name = "lastUpdated") val lastUpdated : Long
)
