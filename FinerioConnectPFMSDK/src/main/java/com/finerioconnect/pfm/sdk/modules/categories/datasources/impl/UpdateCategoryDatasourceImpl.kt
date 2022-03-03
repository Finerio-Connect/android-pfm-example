package com.finerioconnect.pfm.sdk.modules.categories.datasources.impl

import com.finerioconnect.core.sdk.models.FCCategory
import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.requests.FCUpdateCategoryRequest
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK
import com.finerioconnect.pfm.sdk.modules.categories.datasources.UpdateCategoryDatasource

class UpdateCategoryDatasourceImpl: BaseDatasourceImpl<FCCategory>(), UpdateCategoryDatasource {

    override fun success(success: (FCCategory) -> Unit) = apply {
        this.success = success
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }

    override fun updateCategory(id: Int, category: FCUpdateCategoryRequest) {
        FinerioConnectPFMSDK.shared.api.updateCategory(getHeaders(), id, category).request()
    }

}