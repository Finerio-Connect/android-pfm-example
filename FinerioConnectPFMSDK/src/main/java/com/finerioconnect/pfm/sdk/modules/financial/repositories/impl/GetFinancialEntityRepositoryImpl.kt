package com.finerioconnect.pfm.sdk.modules.financial.repositories.impl

import com.finerioconnect.pfm.sdk.modules.financial.datasource.GetFinancialEntityDatasource
import com.finerioconnect.pfm.sdk.modules.financial.listeners.GetFinancialEntityListener
import com.finerioconnect.pfm.sdk.modules.financial.repositories.GetFinancialEntityRepository

class GetFinancialEntityRepositoryImpl constructor(
    private val datasource: GetFinancialEntityDatasource
) : GetFinancialEntityRepository {
    private var listener: GetFinancialEntityListener? = null

    override fun setListener(listener: GetFinancialEntityListener) = apply {
        this.listener = listener
    }

    override fun getFinancialEntity(id: Int) {
        datasource
            .success {
                listener?.financialEntityObtained(it)
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        datasource.getFinancialEntity(id)
    }

    override fun cancelRequest() {
        datasource.cancel()
    }
}