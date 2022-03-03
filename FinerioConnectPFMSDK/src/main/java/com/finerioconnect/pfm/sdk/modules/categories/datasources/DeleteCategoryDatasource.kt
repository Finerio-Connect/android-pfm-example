package com.finerioconnect.pfm.sdk.modules.categories.datasources

import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface DeleteCategoryDatasource: BaseDatasource {

    fun success(success: (Any) -> Unit): DeleteCategoryDatasource

    fun deleteCategory(id: Int)

}