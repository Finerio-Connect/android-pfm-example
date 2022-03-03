package com.finerioconnect.pfm.sdk.modules.financial.repositories.impl

import com.finerioconnect.core.sdk.models.requests.FCUpdateFinancialEntityRequest
import com.finerioconnect.pfm.sdk.modules.financial.datasource.UpdateFinancialEntityDatasource
import com.finerioconnect.pfm.sdk.modules.financial.listeners.UpdateFinancialEntityListener
import com.finerioconnect.pfm.sdk.modules.financial.repositories.UpdateFinancialEntityRepository

class UpdateFinancialEntityRepositoryImpl constructor(
    private val datasource: UpdateFinancialEntityDatasource
) : UpdateFinancialEntityRepository {
    private var listener: UpdateFinancialEntityListener? = null

    override fun setListener(listener: UpdateFinancialEntityListener) = apply {
        this.listener = listener
    }

    override fun updateFinancialEntity(id: Int, financialEntity: FCUpdateFinancialEntityRequest) {
        datasource
            .success {
                listener?.financialEntityUpdated(it)
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        datasource.updateFinancialEntity(id, financialEntity)
    }

    override fun cancelRequest() {
        datasource.cancel()
    }
}