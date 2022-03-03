package com.finerioconnect.pfm.sdk.modules.insights.repositories.impl

import com.finerioconnect.pfm.sdk.modules.insights.datasource.GetSummaryDatasource
import com.finerioconnect.pfm.sdk.modules.insights.listeners.GetSummaryListener
import com.finerioconnect.pfm.sdk.modules.insights.repositories.GetSummaryRepository

class GetSummaryRepositoryImpl constructor(
    private val datasource: GetSummaryDatasource
) : GetSummaryRepository {

    private var listener: GetSummaryListener? = null

    override fun setListener(listener: GetSummaryListener) = apply {
        this.listener = listener
    }

    override fun getSummary(userId: Int, accountId: Int?, dateFrom: Number, dateTo: Number) {
        datasource
            .success {
                listener?.summary(it)
            }.error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        datasource.getSummary(userId, accountId, dateFrom, dateTo)
    }

    override fun cancelRequest() {
        datasource.cancel()
    }
}