package com.finerioconnect.core.sdk.models.responses

import com.finerioconnect.core.sdk.models.FCFinancialEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FCFinancialEntitiesResponse(
    @Json(name = "data") val data : List<FCFinancialEntity>,
    @Json(name = "nextCursor") val nextCursor : Int?
)
