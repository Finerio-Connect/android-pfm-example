package com.finerioconnect.core.sdk.models.requests

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * CreateAccountRequest
 *
 * @param userId The ID of the user that owns the account.
 * @param financialEntityId The ID of the financial entity of the account.
 * @param nature Enum: "Debit" "Credit card" "Credit" "Investment" "Mortgage" The nature of the account.
 * @param name The name of the account.
 * @param number The name of the account.
 * @param balance The name of the account.
 * @param chargeable A flag that indicates if the balance of an account will change with transactions changes. False by default.
 */
@JsonClass(generateAdapter = true)
data class FCCreateAccountRequest(
    @Json(name = "userId")
    var userId: Int?,
    @Json(name = "financialEntityId")
    var financialEntityId: Int?,
    @Json(name = "nature")
    var nature: String?,
    @Json(name = "name")
    var name: String?,
    @Json(name = "number")
    var number: String?,
    @Json(name = "balance")
    var balance: Double?,
    @Json(name = "chargeable")
    var chargeable: Boolean?
)