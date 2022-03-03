package com.finerioconnect.core.sdk.models.responses

import com.finerioconnect.core.sdk.models.FCAccount
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * FCAccountsResponse
 *
 * @param data  Array of objects (Account).
 * @param nextCursor The ID to be used in the next request in the 'cursor' query parameter.
 */
@JsonClass(generateAdapter = true)
data class FCAccountsResponse(
    @Json(name = "data")
    var data: List<FCAccount>?,
    @Json(name = "nextCursor")
    var nextCursor: Int?
)