package com.finerioconnect.pfm.sdk.modules.financial.datasource.impl

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.FCFinancialEntity
import com.finerioconnect.core.sdk.models.requests.FCCreateFinancialEntityRequest
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK
import com.finerioconnect.pfm.sdk.modules.financial.datasource.CreateFinancialEntityDatasource

class CreateFinancialEntityDatasourceImpl : BaseDatasourceImpl<FCFinancialEntity>(),
    CreateFinancialEntityDatasource {

    override fun createFinancialEntity(financialEntity: FCCreateFinancialEntityRequest) {
        FinerioConnectPFMSDK.shared.api.createFinancialEntity(getJsonHeaders(), financialEntity).request()
    }

    override fun success(success: (FCFinancialEntity) -> Unit) =  apply {
        this.success = success
    }


    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }
}