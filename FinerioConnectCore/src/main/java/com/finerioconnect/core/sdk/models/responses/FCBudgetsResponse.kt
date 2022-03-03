package com.finerioconnect.core.sdk.models.responses

import com.finerioconnect.core.sdk.models.FCBudget
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FCBudgetsResponse(
    @Json(name = "data") val budgets : List<FCBudget>,
    @Json(name = "nextCursor") val nextCursor : Int?
)
