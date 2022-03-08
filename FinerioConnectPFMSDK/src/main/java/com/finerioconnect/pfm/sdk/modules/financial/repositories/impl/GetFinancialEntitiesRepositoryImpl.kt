package com.finerioconnect.pfm.sdk.modules.financial.repositories.impl

import com.finerioconnect.pfm.sdk.modules.financial.datasource.GetFinancialEntitiesDatasource
import com.finerioconnect.pfm.sdk.modules.financial.listeners.GetFinancialEntitiesListener
import com.finerioconnect.pfm.sdk.modules.financial.repositories.GetFinancialEntitiesRepository

class GetFinancialEntitiesRepositoryImpl constructor(
    private val datasource: GetFinancialEntitiesDatasource
) : GetFinancialEntitiesRepository {
    private var listener: GetFinancialEntitiesListener? = null

    override fun setListener(listener: GetFinancialEntitiesListener) = apply {
        this.listener = listener
    }

    override fun getFinancialEntities(cursor: Int?) {
        datasource
            .success {
                listener?.financialEntitiesObtained(it)
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        datasource.getFinancialEntities(cursor)
    }

    override fun cancelRequest() {
        datasource.cancel()
    }
}