package com.finerioconnect.core.sdk.models.responses

import com.finerioconnect.core.sdk.models.FCTransaction
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * FCTransactionsResponse
 *
 * @param data Array of objects (Transaction).
 * @param nextCursor The ID to be used in the next request in the 'cursor' query parameter.
 */
@JsonClass(generateAdapter = true)
data class FCTransactionsResponse(
    @Json(name = "data") var data: List<FCTransaction>?,
    @Json(name = "nextCursor") var nextCursor: Int?
)
