package com.finerioconnect.core.sdk.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FCBudget(
    @Json(name = "id") val id : Int,
    @Json(name = "categoryId") val categoryId : Int,
    @Json(name = "name") val name : String,
    @Json(name = "amount") val amount : Double,
    @Json(name = "warningPercentage") val warningPercentage : Double,
    @Json(name = "spent") val spent : Double,
    @Json(name = "leftToSpend") val leftToSpend : Double,
    @Json(name = "status") val status : String,
    @Json(name = "dateCreated") val dateCreated : Long,
    @Json(name = "lastUpdated") val lastUpdated : Long
)
