package com.finerioconnect.pfm.sdk.modules.categories.repositories

import com.finerioconnect.pfm.sdk.modules.categories.listeners.DeleteCategoryListener

interface DeleteCategoryRepository {

    fun setListener(listener: DeleteCategoryListener): DeleteCategoryRepository

    fun deleteCategory(categoryId: Int)

    fun cancelRequest()

}