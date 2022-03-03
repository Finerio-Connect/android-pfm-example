package com.finerioconnect.pfm.sdk.modules.categories.repositories

import com.finerioconnect.core.sdk.models.requests.FCCreateCategoryRequest
import com.finerioconnect.pfm.sdk.modules.categories.listeners.CreateCategoryListener

interface CreateCategoryRepository {

    fun setListener(listener: CreateCategoryListener): CreateCategoryRepository

    fun createCategory(category: FCCreateCategoryRequest)

    fun cancelRequest()

}