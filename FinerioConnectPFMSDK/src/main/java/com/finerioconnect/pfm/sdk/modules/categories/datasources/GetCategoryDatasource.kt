package com.finerioconnect.pfm.sdk.modules.categories.datasources

import com.finerioconnect.core.sdk.models.FCCategory
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface GetCategoryDatasource: BaseDatasource {

    fun success(success: (FCCategory) -> Unit): GetCategoryDatasource

    fun getCategory(id: Int)

}