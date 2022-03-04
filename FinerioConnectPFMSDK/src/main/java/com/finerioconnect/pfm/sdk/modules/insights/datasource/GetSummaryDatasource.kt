package com.finerioconnect.pfm.sdk.modules.insights.datasource

import com.finerioconnect.core.sdk.models.responses.FCSummaryResponse
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface GetSummaryDatasource : BaseDatasource {
    fun success(success: (FCSummaryResponse) -> Unit): GetSummaryDatasource
    fun getSummary(userId: Int, accountId: Int?, dateFrom: Long?, dateTo: Long?)
}