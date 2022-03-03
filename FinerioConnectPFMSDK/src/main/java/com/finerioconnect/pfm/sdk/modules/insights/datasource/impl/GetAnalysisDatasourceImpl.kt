package com.finerioconnect.pfm.sdk.modules.insights.datasource.impl

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.responses.FCAnalysisResponse
import com.finerioconnect.pfm.sdk.modules.insights.datasource.GetAnalysisDatasource
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK

class GetAnalysisDatasourceImpl : BaseDatasourceImpl<FCAnalysisResponse>(), GetAnalysisDatasource {

    override fun success(success: (FCAnalysisResponse) -> Unit) = apply {
        this.success = success
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }

    override fun getAnalysis(userId: Int, accountId: Int?, dateFrom: Long?, dateTo: Long?) {
        val params = HashMap<String, String>()
        accountId?.let { params["accountId"] = it.toString() }
        dateFrom?.let { params["dateFrom"] = it.toString() }
        dateTo?.let { params["dateTo"] = it.toString() }
        FinerioConnectPFMSDK.shared.api.getAnalysis(getHeaders(), userId, params).request()
    }

}