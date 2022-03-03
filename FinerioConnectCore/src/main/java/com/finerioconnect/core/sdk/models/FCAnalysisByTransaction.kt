package com.finerioconnect.core.sdk.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * FCAnalysisByTransaction
 *
 * @param description The description of the transaction
 * @param average The average of the transaction.
 * @param quantity The quantity of the transaction.
 * @param amount The amount of the transaction.
 */
@JsonClass(generateAdapter = true)
data class FCAnalysisByTransaction(
    @Json(name = "description") val description: String,
    @Json(name = "average") val average: Double,
    @Json(name = "quantity") val quantity: Int,
    @Json(name = "amount") val amount: Double,
)
