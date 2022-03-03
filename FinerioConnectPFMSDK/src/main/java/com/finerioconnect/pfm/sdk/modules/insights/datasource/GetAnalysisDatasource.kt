package com.finerioconnect.pfm.sdk.modules.insights.datasource

import com.finerioconnect.core.sdk.models.responses.FCAnalysisResponse
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface GetAnalysisDatasource: BaseDatasource {

    fun success(success: (FCAnalysisResponse) -> Unit): GetAnalysisDatasource

    fun getAnalysis(userId: Int, accountId: Int?, dateFrom: Long?, dateTo: Long?)

}