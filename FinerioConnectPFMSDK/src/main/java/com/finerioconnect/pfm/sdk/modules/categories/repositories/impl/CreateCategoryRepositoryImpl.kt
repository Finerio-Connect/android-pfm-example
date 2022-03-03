package com.finerioconnect.pfm.sdk.modules.categories.repositories.impl

import com.finerioconnect.core.sdk.models.requests.FCCreateCategoryRequest
import com.finerioconnect.pfm.sdk.modules.categories.datasources.CreateCategoryDatasource
import com.finerioconnect.pfm.sdk.modules.categories.listeners.CreateCategoryListener
import com.finerioconnect.pfm.sdk.modules.categories.repositories.CreateCategoryRepository

class CreateCategoryRepositoryImpl(
    private val createCategoryDatasource: CreateCategoryDatasource
): CreateCategoryRepository {

    private var listener: CreateCategoryListener?= null

    override fun setListener(listener: CreateCategoryListener) = apply {
        this.listener = listener
    }

    override fun createCategory(category: FCCreateCategoryRequest) {
        createCategoryDatasource
            .success {
                listener?.categoryCreated(it)
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        createCategoryDatasource.createCategory(category)
    }

    override fun cancelRequest() {
        createCategoryDatasource.cancel()
    }

}