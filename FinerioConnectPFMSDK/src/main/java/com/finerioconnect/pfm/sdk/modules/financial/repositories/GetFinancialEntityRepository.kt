package com.finerioconnect.pfm.sdk.modules.financial.repositories

import com.finerioconnect.pfm.sdk.modules.financial.listeners.GetFinancialEntityListener

interface GetFinancialEntityRepository {
    fun setListener(listener: GetFinancialEntityListener): GetFinancialEntityRepository
    fun getFinancialEntity(id: Int)
    fun cancelRequest()
}