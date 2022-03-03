package com.finerioconnect.pfm.sdk.modules.categories.repositories.impl

import com.finerioconnect.pfm.sdk.modules.categories.datasources.GetCategoryDatasource
import com.finerioconnect.pfm.sdk.modules.categories.listeners.GetCategoryListener
import com.finerioconnect.pfm.sdk.modules.categories.repositories.GetCategoryRepository

class GetCategoryRepositoryImpl(
    private val getCategoryDatasource: GetCategoryDatasource
) : GetCategoryRepository {

    private var listener: GetCategoryListener? = null

    override fun setListener(listener: GetCategoryListener) = apply {
        this.listener = listener
    }

    override fun getCategory(categoryId: Int) {
        getCategoryDatasource
            .success {
                listener?.category(it)
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        getCategoryDatasource.getCategory(categoryId)
    }

    override fun cancelRequest() {
        getCategoryDatasource.cancel()
    }

}