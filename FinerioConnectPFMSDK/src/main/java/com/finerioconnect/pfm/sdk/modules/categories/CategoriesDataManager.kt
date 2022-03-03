package com.finerioconnect.pfm.sdk.modules.categories

import com.finerioconnect.core.sdk.models.requests.FCCreateCategoryRequest
import com.finerioconnect.core.sdk.models.requests.FCUpdateCategoryRequest
import com.finerioconnect.pfm.sdk.modules.categories.datasources.impl.*
import com.finerioconnect.pfm.sdk.modules.categories.listeners.*
import com.finerioconnect.pfm.sdk.modules.categories.repositories.impl.*

class CategoriesDataManager {

    fun create(category: FCCreateCategoryRequest, listener: CreateCategoryListener) {
        CreateCategoryRepositoryImpl(CreateCategoryDatasourceImpl())
            .setListener(listener)
            .createCategory(category)
    }

    fun getAll(userId: Int?, cursor: Int?, listener: GetCategoriesListener) {
        GetCategoriesRepositoryImpl(GetCategoriesDatasourceImpl())
            .setListener(listener)
            .getCategories(userId, cursor)
    }

    fun get(categoryId: Int, listener: GetCategoryListener) {
        GetCategoryRepositoryImpl(GetCategoryDatasourceImpl())
            .setListener(listener)
            .getCategory(categoryId)
    }

    fun update(
        categoryId: Int,
        category: FCUpdateCategoryRequest,
        listener: UpdateCategoryListener
    ) {
        UpdateCategoryRepositoryImpl(UpdateCategoryDatasourceImpl())
            .setListener(listener)
            .updateCategory(categoryId, category)
    }

    fun delete(categoryId: Int, listener: DeleteCategoryListener) {
        DeleteCategoryRepositoryImpl(DeleteCategoryDatasourceImpl())
            .setListener(listener)
            .deleteCategory(categoryId)
    }

}