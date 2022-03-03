package com.finerioconnect.core.sdk.models.responses

import com.finerioconnect.core.sdk.models.FCCategory
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * FCCategoriesResponse
 *
 * @param data Array of objects (Category).
 * @param nextCursor The ID to be used in the next request in the 'cursor' query parameter.
 */
@JsonClass(generateAdapter = true)
data class FCCategoriesResponse(
    @Json(name = "data") var data: List<FCCategory>?,
    @Json(name = "nextCursor") var nextCursor: Int?
)
