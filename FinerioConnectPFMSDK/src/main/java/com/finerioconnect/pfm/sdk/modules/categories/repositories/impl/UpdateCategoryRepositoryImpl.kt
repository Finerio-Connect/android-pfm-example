package com.finerioconnect.pfm.sdk.modules.categories.repositories.impl

import com.finerioconnect.core.sdk.models.requests.FCUpdateCategoryRequest
import com.finerioconnect.pfm.sdk.modules.categories.datasources.UpdateCategoryDatasource
import com.finerioconnect.pfm.sdk.modules.categories.listeners.UpdateCategoryListener
import com.finerioconnect.pfm.sdk.modules.categories.repositories.UpdateCategoryRepository

class UpdateCategoryRepositoryImpl(
    private val updateCategoryDatasource: UpdateCategoryDatasource
) : UpdateCategoryRepository {

    private var listener: UpdateCategoryListener? = null

    override fun setListener(listener: UpdateCategoryListener) = apply {
        this.listener = listener
    }

    override fun updateCategory(categoryId: Int, category: FCUpdateCategoryRequest) {
        updateCategoryDatasource
            .success {
                listener?.categoryUpdated(it)
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        updateCategoryDatasource.updateCategory(categoryId, category)
    }

    override fun cancelRequest() {
        updateCategoryDatasource.cancel()
    }

}