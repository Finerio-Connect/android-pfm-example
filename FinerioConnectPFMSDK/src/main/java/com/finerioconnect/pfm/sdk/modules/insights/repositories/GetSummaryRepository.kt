package com.finerioconnect.pfm.sdk.modules.insights.repositories

import com.finerioconnect.pfm.sdk.modules.insights.listeners.GetSummaryListener

interface GetSummaryRepository {
    fun setListener(listener: GetSummaryListener): GetSummaryRepository
    fun getSummary(userId: Int, accountId: Int?, dateFrom: Long?, dateTo: Long?)
    fun cancelRequest()
}