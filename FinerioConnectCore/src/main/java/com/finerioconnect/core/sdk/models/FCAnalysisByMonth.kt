package com.finerioconnect.core.sdk.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * FCAnalysisByMonth
 *
 * @param date The year and month of the information.
 * @param categories The financial information grouped by categories
 */
@JsonClass(generateAdapter = true)
data class FCAnalysisByMonth(
    @Json(name = "date") var date: Long,
    @Json(name = "categories") var categories: List<FCAnalysisByCategory>
)
