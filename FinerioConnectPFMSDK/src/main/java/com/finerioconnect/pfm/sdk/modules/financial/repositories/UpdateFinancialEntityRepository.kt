package com.finerioconnect.pfm.sdk.modules.financial.repositories

import com.finerioconnect.core.sdk.models.requests.FCUpdateFinancialEntityRequest
import com.finerioconnect.pfm.sdk.modules.financial.listeners.UpdateFinancialEntityListener

interface UpdateFinancialEntityRepository {
    fun setListener(listener: UpdateFinancialEntityListener): UpdateFinancialEntityRepository
    fun updateFinancialEntity(id: Int, financialEntity: FCUpdateFinancialEntityRequest)
    fun cancelRequest()
}