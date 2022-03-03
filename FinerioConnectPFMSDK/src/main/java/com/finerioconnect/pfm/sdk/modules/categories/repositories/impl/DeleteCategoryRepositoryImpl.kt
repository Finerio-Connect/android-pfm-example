package com.finerioconnect.pfm.sdk.modules.categories.repositories.impl

import com.finerioconnect.pfm.sdk.modules.categories.datasources.DeleteCategoryDatasource
import com.finerioconnect.pfm.sdk.modules.categories.listeners.DeleteCategoryListener
import com.finerioconnect.pfm.sdk.modules.categories.repositories.DeleteCategoryRepository

class DeleteCategoryRepositoryImpl(
    private val deleteCategoryDatasource: DeleteCategoryDatasource
) : DeleteCategoryRepository {

    private var listener: DeleteCategoryListener? = null

    override fun setListener(listener: DeleteCategoryListener) = apply {
        this.listener = listener
    }

    override fun deleteCategory(categoryId: Int) {
        deleteCategoryDatasource
            .success {
                listener?.categoryDeleted()
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        deleteCategoryDatasource.deleteCategory(categoryId)
    }

    override fun cancelRequest() {
        deleteCategoryDatasource.cancel()
    }

}