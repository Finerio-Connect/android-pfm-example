package com.finerioconnect.pfm.sdk.modules.financial.datasource.impl

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.responses.FCFinancialEntitiesResponse
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK
import com.finerioconnect.pfm.sdk.modules.financial.datasource.GetFinancialEntitiesDatasource

class GetFinancialEntitiesDatasourceImpl : BaseDatasourceImpl<FCFinancialEntitiesResponse>(),
    GetFinancialEntitiesDatasource {

    override fun getFinancialEntities(userId: Int, cursor: Int?) {
        FinerioConnectPFMSDK.shared.api.getFinancialEntities(getHeaders(), userId, cursor).request()
    }

    override fun success(success: (FCFinancialEntitiesResponse) -> Unit) = apply {
        this.success = success
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }
}