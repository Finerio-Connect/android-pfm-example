package com.finerioconnect.pfm.sdk.modules.financial.repositories

import com.finerioconnect.pfm.sdk.modules.financial.listeners.DeleteFinancialEntityListener

interface DeleteFinancialEntityRepository {
    fun setListener(listener: DeleteFinancialEntityListener): DeleteFinancialEntityRepository
    fun deleteFinancialEntity(id: Int)
    fun cancelRequest()
}