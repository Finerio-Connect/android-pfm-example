package com.finerioconnect.pfm.sdk.modules.insights.repositories.impl

import com.finerioconnect.pfm.sdk.modules.insights.datasource.GetAnalysisDatasource
import com.finerioconnect.pfm.sdk.modules.insights.listeners.GetAnalysisListener
import com.finerioconnect.pfm.sdk.modules.insights.repositories.GetAnalysisRepository

class GetAnalysisRepositoryImpl constructor(
    private val getAnalysisDatasource: GetAnalysisDatasource
): GetAnalysisRepository {

    private var listener: GetAnalysisListener?= null

    override fun setListener(listener: GetAnalysisListener) = apply {
        this.listener = listener
    }

    override fun getAnalysis(userId: Int, accountId: Int?, dateFrom: Long?, dateTo: Long?) {
        getAnalysisDatasource
            .success {
                listener?.analysis(it.data)
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        getAnalysisDatasource.getAnalysis(userId, accountId, dateFrom, dateTo)
    }

    override fun cancelRequest() {
        getAnalysisDatasource.cancel()
    }

}