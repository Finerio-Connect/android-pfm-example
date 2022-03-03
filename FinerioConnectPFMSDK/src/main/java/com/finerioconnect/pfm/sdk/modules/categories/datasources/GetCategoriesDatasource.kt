package com.finerioconnect.pfm.sdk.modules.categories.datasources

import com.finerioconnect.core.sdk.models.responses.FCCategoriesResponse
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface GetCategoriesDatasource: BaseDatasource {

    fun success(success: (FCCategoriesResponse) -> Unit): GetCategoriesDatasource

    fun getCategories(userId: Int?, cursor: Int?)

}