package com.finerioconnect.core.sdk.models.responses

import com.finerioconnect.core.sdk.models.FCResumeBalance
import com.finerioconnect.core.sdk.models.FCResumeByMonth
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * SummaryResponse
 *
 * @param incomes List of objects (IncomesModel).
 * @param expenses List of objects (ExpensesModel).
 * @param balances List of objects (BalancesModel).
 */
@JsonClass(generateAdapter = true)
data class FCSummaryResponse(
    @Json(name = "incomes") val incomes : List<FCResumeByMonth>,
    @Json(name = "expenses") val expenses : List<FCResumeByMonth>,
    @Json(name = "balances") val balances : List<FCResumeBalance>
)
