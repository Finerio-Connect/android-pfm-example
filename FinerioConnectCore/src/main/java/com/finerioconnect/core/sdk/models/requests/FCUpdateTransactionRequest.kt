package com.finerioconnect.core.sdk.models.requests

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * CreateTransactionRequest
 *
 * @param date The date of the transaction.
 * @param charge A flag that indicates if the transaction is a charge or a deposit.
 * @param description The description of the transaction.
 * @param amount The amount of the transaction.
 * @param categoryId The category ID of the transaction.
 */
@JsonClass(generateAdapter = true)
data class FCUpdateTransactionRequest(
    @Json(name = "date") val date: Long,
    @Json(name = "charge") val charge: Boolean,
    @Json(name = "description") val description: String,
    @Json(name = "amount") val amount: Double,
    @Json(name = "categoryId") var categoryId: Int? = null
)