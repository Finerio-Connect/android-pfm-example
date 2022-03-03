package com.finerioconnect.pfm.sdk.modules.financial.datasource.impl

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK
import com.finerioconnect.pfm.sdk.modules.financial.datasource.DeleteFinancialEntityDatasource

class DeleteFinancialEntityDatasourceImpl : BaseDatasourceImpl<Unit>(),
    DeleteFinancialEntityDatasource {
    override fun deleteFinancialEntity(id: Int) {
        FinerioConnectPFMSDK.shared.api.deleteFinancialEntity(getHeaders(), id).request()
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun success(success: (Any) -> Unit) = apply {
        this.success = success
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }
}