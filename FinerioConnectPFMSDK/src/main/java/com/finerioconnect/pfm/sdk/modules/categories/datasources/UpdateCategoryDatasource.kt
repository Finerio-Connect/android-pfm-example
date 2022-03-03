package com.finerioconnect.pfm.sdk.modules.categories.datasources

import com.finerioconnect.core.sdk.models.FCCategory
import com.finerioconnect.core.sdk.models.requests.FCUpdateCategoryRequest
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface UpdateCategoryDatasource: BaseDatasource {

    fun success(success: (FCCategory) -> Unit): UpdateCategoryDatasource

    fun updateCategory(id: Int, category: FCUpdateCategoryRequest)

}