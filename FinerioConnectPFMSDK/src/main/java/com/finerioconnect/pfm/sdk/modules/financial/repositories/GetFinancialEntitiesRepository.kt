package com.finerioconnect.pfm.sdk.modules.financial.repositories

import com.finerioconnect.pfm.sdk.modules.financial.listeners.GetFinancialEntitiesListener

interface GetFinancialEntitiesRepository {
    fun setListener(listener: GetFinancialEntitiesListener): GetFinancialEntitiesRepository
    fun getFinancialEntities(cursor: Int?)
    fun cancelRequest()
}