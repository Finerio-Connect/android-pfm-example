package com.finerioconnect.pfm.sdk.modules.financial.repositories

import com.finerioconnect.core.sdk.models.requests.FCCreateFinancialEntityRequest
import com.finerioconnect.pfm.sdk.modules.financial.listeners.CreateFinancialEntityListener

interface CreateFinancialEntityRepository {
    fun setListener(listener: CreateFinancialEntityListener): CreateFinancialEntityRepository
    fun createFinancialEntity(financialEntity: FCCreateFinancialEntityRequest)
    fun cancelRequest()
}