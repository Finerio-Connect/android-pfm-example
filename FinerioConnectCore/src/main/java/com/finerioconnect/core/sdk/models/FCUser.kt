package com.finerioconnect.core.sdk.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FCUser(
    @Json(name = "id") val id : Int,
    @Json(name = "name") val name : String,
    @Json(name = "dateCreated") val dateCreated : Long,
)
