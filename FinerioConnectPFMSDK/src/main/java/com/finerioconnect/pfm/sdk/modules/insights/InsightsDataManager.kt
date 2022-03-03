package com.finerioconnect.pfm.sdk.modules.insights

import com.finerioconnect.pfm.sdk.modules.insights.datasource.impl.GetAnalysisDatasourceImpl
import com.finerioconnect.pfm.sdk.modules.insights.datasource.impl.GetSummaryDatasourceImpl
import com.finerioconnect.pfm.sdk.modules.insights.listeners.GetAnalysisListener
import com.finerioconnect.pfm.sdk.modules.insights.listeners.GetSummaryListener
import com.finerioconnect.pfm.sdk.modules.insights.repositories.impl.GetAnalysisRepositoryImpl
import com.finerioconnect.pfm.sdk.modules.insights.repositories.impl.GetSummaryRepositoryImpl

class InsightsDataManager {

    fun getSummary(
        userId: Int,
        accountId: Int?,
        dateFrom: Number,
        dateTo: Number,
        listener: GetSummaryListener
    ) {
        GetSummaryRepositoryImpl(GetSummaryDatasourceImpl())
            .setListener(listener)
            .getSummary(userId, accountId, dateFrom, dateTo)
    }

    fun getAnalysis(
        userId: Int,
        accountId: Int?,
        dateFrom: Long?,
        dateTo: Long?,
        listener: GetAnalysisListener
    ) {
        GetAnalysisRepositoryImpl(GetAnalysisDatasourceImpl())
            .setListener(listener)
            .getAnalysis(userId, accountId, dateFrom, dateTo)
    }

}