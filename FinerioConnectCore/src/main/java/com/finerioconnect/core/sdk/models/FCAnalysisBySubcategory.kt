package com.finerioconnect.core.sdk.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * FCAnalysisBySubcategory
 *
 * @param categoryId The system ID of the subcategory.
 * @param average The average of the subcategory.
 * @param quantity The quantity of the subcategory.
 * @param amount The amount of the subcategory.
 * @param transactions The transactions grouped by date
 */
@JsonClass(generateAdapter = true)
data class FCAnalysisBySubcategory(
    @Json(name = "categoryId") val categoryId : Int,
    @Json(name = "average") val average : Double,
    @Json(name = "quantity") val quantity : Int,
    @Json(name = "amount") val amount : Double,
    @Json(name = "transactions") val transactions : List<FCAnalysisByTransaction>
)
