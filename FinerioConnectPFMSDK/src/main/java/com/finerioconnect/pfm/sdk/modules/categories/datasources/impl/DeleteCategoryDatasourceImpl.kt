package com.finerioconnect.pfm.sdk.modules.categories.datasources.impl

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.pfm.sdk.base.BaseDatasource
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK
import com.finerioconnect.pfm.sdk.modules.categories.datasources.DeleteCategoryDatasource

class DeleteCategoryDatasourceImpl: BaseDatasourceImpl<Unit>(), DeleteCategoryDatasource {

    override fun success(success: (Any) -> Unit) = apply {
        this.success = success
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }

    override fun deleteCategory(id: Int) {
        FinerioConnectPFMSDK.shared.api.deleteCategory(getHeaders(), id).request()
    }

}