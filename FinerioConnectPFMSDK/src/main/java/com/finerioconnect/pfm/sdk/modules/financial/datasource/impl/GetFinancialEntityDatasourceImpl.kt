package com.finerioconnect.pfm.sdk.modules.financial.datasource.impl

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.FCFinancialEntity
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK
import com.finerioconnect.pfm.sdk.modules.financial.datasource.GetFinancialEntityDatasource

class GetFinancialEntityDatasourceImpl : BaseDatasourceImpl<FCFinancialEntity>(),
    GetFinancialEntityDatasource {

    override fun getFinancialEntity(id: Int) {
        FinerioConnectPFMSDK.shared.api.getFinancialEntity(getHeaders(), id).request()
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun success(success: (FCFinancialEntity) -> Unit) = apply {
        this.success = success
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }
}