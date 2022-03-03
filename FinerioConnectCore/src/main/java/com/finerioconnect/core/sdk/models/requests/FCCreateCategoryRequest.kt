package com.finerioconnect.core.sdk.models.requests

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FCCreateCategoryRequest(
    @Json(name = "userId") val userId : Int?,
    @Json(name = "name") val name : String,
    @Json(name = "color") val color : String?,
    @Json(name = "parentCategoryId") val parentCategoryId : Int?
)