package com.finerioconnect.pfm.sdk.modules.insights.repositories

import com.finerioconnect.pfm.sdk.modules.insights.listeners.GetAnalysisListener

interface GetAnalysisRepository {

    fun setListener(listener: GetAnalysisListener): GetAnalysisRepository

    /**
     * @param userId The ID of the user to fetch the analysis; Example: userId=123
     * @param accountId The ID of the account to fetch the analysis. If it is not present, the API will use all the accounts of the user; Example: accountId=123
     * @param dateFrom The date where the analysis starts, in UNIX format; Example: dateFrom=1587567125458
     * @param dateTo The date where the analysis ends, in UNIX format; Example: dateTo=1587567125458
     */
    fun getAnalysis(userId: Int, accountId: Int?, dateFrom: Long?, dateTo: Long?)

    fun cancelRequest()

}