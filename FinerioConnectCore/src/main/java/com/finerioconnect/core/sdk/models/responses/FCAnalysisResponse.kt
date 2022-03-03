package com.finerioconnect.core.sdk.models.responses

import com.finerioconnect.core.sdk.models.FCAnalysisByMonth
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * FCAnalysisResponse
 *
 * @param data The analysis of a user, grouped by month by default.
 */
@JsonClass(generateAdapter = true)
data class FCAnalysisResponse(
    @Json(name = "data") var data: List<FCAnalysisByMonth>
)
