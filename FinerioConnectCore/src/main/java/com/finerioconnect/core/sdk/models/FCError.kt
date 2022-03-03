package com.finerioconnect.core.sdk.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * FCError
 *
 * @param title A brief reason of the error.
 * @param code A unique code of the error.
 * @param detail A detailed description of the error.
 */
@JsonClass(generateAdapter = true)
data class FCError(
    @Json(name = "title") var title: String,
    @Json(name = "code") var code: String,
    @Json(name = "detail") var detail: String
)
