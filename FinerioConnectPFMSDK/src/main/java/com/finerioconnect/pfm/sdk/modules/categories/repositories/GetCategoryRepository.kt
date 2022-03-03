package com.finerioconnect.pfm.sdk.modules.categories.repositories

import com.finerioconnect.pfm.sdk.modules.categories.listeners.GetCategoryListener

interface GetCategoryRepository {

    fun setListener(listener: GetCategoryListener): GetCategoryRepository

    fun getCategory(categoryId: Int)

    fun cancelRequest()

}