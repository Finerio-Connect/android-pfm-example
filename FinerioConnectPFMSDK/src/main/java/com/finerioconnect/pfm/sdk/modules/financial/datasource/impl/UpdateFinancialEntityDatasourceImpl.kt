package com.finerioconnect.pfm.sdk.modules.financial.datasource.impl

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.FCFinancialEntity
import com.finerioconnect.core.sdk.models.requests.FCUpdateFinancialEntityRequest
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK
import com.finerioconnect.pfm.sdk.modules.financial.datasource.UpdateFinancialEntityDatasource

class UpdateFinancialEntityDatasourceImpl : BaseDatasourceImpl<FCFinancialEntity>(),
    UpdateFinancialEntityDatasource {

    override fun success(success: (FCFinancialEntity) -> Unit) = apply {
        this.success = success
    }

    override fun updateFinancialEntity(
        id: Int,
        updateFinancialEntityRequest: FCUpdateFinancialEntityRequest
    ) {
        FinerioConnectPFMSDK.shared.api.updateFinancialEntity(
            getHeaders(),
            id,
            updateFinancialEntityRequest
        ).request()
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }
}