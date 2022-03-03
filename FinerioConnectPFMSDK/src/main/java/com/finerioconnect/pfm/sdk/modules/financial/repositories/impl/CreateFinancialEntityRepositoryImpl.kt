package com.finerioconnect.pfm.sdk.modules.financial.repositories.impl

import com.finerioconnect.core.sdk.models.requests.FCCreateFinancialEntityRequest
import com.finerioconnect.pfm.sdk.modules.financial.datasource.CreateFinancialEntityDatasource
import com.finerioconnect.pfm.sdk.modules.financial.listeners.CreateFinancialEntityListener
import com.finerioconnect.pfm.sdk.modules.financial.repositories.CreateFinancialEntityRepository

class CreateFinancialEntityRepositoryImpl constructor(
    private val datasource: CreateFinancialEntityDatasource
) : CreateFinancialEntityRepository {

    private var listener: CreateFinancialEntityListener? = null

    override fun setListener(listener: CreateFinancialEntityListener) = apply {
        this.listener = listener
    }

    override fun createFinancialEntity(financialEntity: FCCreateFinancialEntityRequest) {
        datasource
            .success {
                listener?.financialEntityCreated(it)
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        datasource.createFinancialEntity(financialEntity)
    }

    override fun cancelRequest() {
        datasource.cancel()
    }
}