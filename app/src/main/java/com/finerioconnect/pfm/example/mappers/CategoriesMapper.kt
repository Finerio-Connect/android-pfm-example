package com.finerioconnect.pfm.example.mappers

import android.graphics.Color
import com.finerioconnect.core.sdk.models.FCCategory
import com.finerioconnect.sdk.models.FCImage

fun getFCCategories(categories: List<FCCategory>): List<com.finerioconnect.sdk.models.FCCategory> {
    val fcCategories = arrayListOf<com.finerioconnect.sdk.models.FCCategory>()
    categories.filter { it.parentCategoryId == null }.forEach { parentCategory ->
        val fcChildCategories = mutableListOf<com.finerioconnect.sdk.models.FCCategory>()
        categories.filter { it.parentCategoryId != null && it.parentCategoryId == parentCategory.id }.forEach { childCategory ->
            fcChildCategories.add(getCategory(childCategory, null))
        }
        fcCategories.add(getCategory(parentCategory, fcChildCategories))
    }
    return fcCategories
}

fun getFCCategoryById(categoryId: Int, categories: List<FCCategory>): com.finerioconnect.sdk.models.FCCategory {
    val category = categories.last { it.id == categoryId }
    return getCategory(category, null)
}

private fun getCategory(category: FCCategory, subCategories: List<com.finerioconnect.sdk.models.FCCategory>?): com.finerioconnect.sdk.models.FCCategory {
    return com.finerioconnect.sdk.models.FCCategory(
        category.id.toString(), category.name, "#ff939598", "#000000",
        FCImage("no_category", Color.parseColor(category.color ?: "#ff939598")),
        null, subCategories,
        if (category.parentCategoryId == null) null else category.parentCategoryId.toString()
    )
}