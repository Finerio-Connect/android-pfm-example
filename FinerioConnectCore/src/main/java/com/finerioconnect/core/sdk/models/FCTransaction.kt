package com.finerioconnect.core.sdk.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * FCTransaction
 *
 * @param id The ID of the transaction.
 * @param date The date of the transaction.
 * @param charge A flag that indicates if the transaction is a charge or a deposit.
 * @param description The description of the transaction.
 * @param amount The amount of the transaction.
 * @param categoryId The category ID of the transaction.
 * @param dateCreated The date when the transaction was created.
 * @param lastUpdated The date when the transaction was updated.
 */
@JsonClass(generateAdapter = true)
data class FCTransaction(
    @Json(name = "id") val id: Int,
    @Json(name = "date") val date: Long,
    @Json(name = "charge") val charge: Boolean,
    @Json(name = "description") val description: String,
    @Json(name = "amount") val amount: Double,
    @Json(name = "categoryId") val categoryId: Int?,
    @Json(name = "dateCreated") val dateCreated: Long,
    @Json(name = "lastUpdated") val lastUpdated: Long
)