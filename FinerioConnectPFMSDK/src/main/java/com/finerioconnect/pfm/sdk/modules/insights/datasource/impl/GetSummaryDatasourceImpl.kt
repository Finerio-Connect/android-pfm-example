package com.finerioconnect.pfm.sdk.modules.insights.datasource.impl

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.responses.FCSummaryResponse
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK
import com.finerioconnect.pfm.sdk.modules.insights.datasource.GetSummaryDatasource

class GetSummaryDatasourceImpl : BaseDatasourceImpl<FCSummaryResponse>(), GetSummaryDatasource {

    override fun getSummary(userId: Int, accountId: Int?, dateFrom: Number, dateTo: Number) {
        FinerioConnectPFMSDK.shared.api.getSummary(getHeaders(), userId, accountId, dateFrom, dateTo).request()
    }

    override fun success(success: (FCSummaryResponse) -> Unit) = apply {
        this.success = success
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }
}