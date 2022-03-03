package com.finerioconnect.core.sdk.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * FCAccount
 *
 * @param id The ID of the account.
 * @param nature Enum: "Debit" "Credit card" "Credit" "Investment" "Mortgage" The nature of the account.
 * @param name The name of the account.
 * @param number The number of the account.
 * @param balance The balance of the account.
 * @param chargeable A flag that indicates if the balance of an account will change with transactions changes.
 * @param dateCreated The date when the account was created.
 * @param lastUpdated The date when the account was updated.
 */
@JsonClass(generateAdapter = true)
data class FCAccount(
    @Json(name = "id")
    var id: Int?,
    @Json(name = "nature")
    var nature: String?,
    @Json(name = "name")
    var name: String?,
    @Json(name = "number")
    var number: String?,
    @Json(name = "balance")
    var balance: Double?,
    @Json(name = "chargeable")
    var chargeable: Boolean?,
    @Json(name = "dateCreated")
    var dateCreated: Long?,
    @Json(name = "lastUpdated")
    var lastUpdated: Long?
)