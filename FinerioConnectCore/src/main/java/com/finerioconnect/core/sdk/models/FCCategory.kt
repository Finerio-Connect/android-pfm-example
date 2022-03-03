package com.finerioconnect.core.sdk.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * FCCategoriesResponse
 *
 * @param id The ID of the category.
 * @param name The name of the category.
 * @param color The color of the category.
 * @param parentCategoryId The ID of the parent category that owns this subcategory.
 * @param userId The ID of the user that owns the category.
 * @param dateCreated The date when the category was created.
 * @param lastUpdated The date when the category was updated.
 */
@JsonClass(generateAdapter = true)
data class FCCategory(
    @Json(name = "id") val id : Int,
    @Json(name = "name") val name : String,
    @Json(name = "color") val color : String?,
    @Json(name = "parentCategoryId") val parentCategoryId : Int?,
    @Json(name = "userId") val userId : Int?,
    @Json(name = "dateCreated") val dateCreated : Long?,
    @Json(name = "lastUpdated") val lastUpdated : Long?
)