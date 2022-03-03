package com.finerioconnect.pfm.sdk.modules.categories.datasources

import com.finerioconnect.core.sdk.models.FCCategory
import com.finerioconnect.core.sdk.models.requests.FCCreateCategoryRequest
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface CreateCategoryDatasource: BaseDatasource {

    fun success(success: (FCCategory) -> Unit): CreateCategoryDatasource

    fun createCategory(category: FCCreateCategoryRequest)

}