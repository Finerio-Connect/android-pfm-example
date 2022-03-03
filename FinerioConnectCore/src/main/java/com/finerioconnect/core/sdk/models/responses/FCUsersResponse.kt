package com.finerioconnect.core.sdk.models.responses

import com.finerioconnect.core.sdk.models.FCUser
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FCUsersResponse(
    @Json(name = "data") val data : List<FCUser>,
    @Json(name = "nextCursor") val nextCursor : Int?
)
