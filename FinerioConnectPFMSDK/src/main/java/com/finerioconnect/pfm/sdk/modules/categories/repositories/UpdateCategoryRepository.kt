package com.finerioconnect.pfm.sdk.modules.categories.repositories

import com.finerioconnect.core.sdk.models.requests.FCUpdateCategoryRequest
import com.finerioconnect.pfm.sdk.modules.categories.listeners.UpdateCategoryListener

interface UpdateCategoryRepository {

    fun setListener(listener: UpdateCategoryListener): UpdateCategoryRepository

    fun updateCategory(categoryId: Int, category: FCUpdateCategoryRequest)

    fun cancelRequest()

}