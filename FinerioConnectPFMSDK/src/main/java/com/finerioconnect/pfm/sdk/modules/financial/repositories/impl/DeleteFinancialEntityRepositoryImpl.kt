package com.finerioconnect.pfm.sdk.modules.financial.repositories.impl

import com.finerioconnect.pfm.sdk.modules.financial.datasource.DeleteFinancialEntityDatasource
import com.finerioconnect.pfm.sdk.modules.financial.listeners.DeleteFinancialEntityListener
import com.finerioconnect.pfm.sdk.modules.financial.repositories.DeleteFinancialEntityRepository

class DeleteFinancialEntityRepositoryImpl constructor(
    private val datasource: DeleteFinancialEntityDatasource
) : DeleteFinancialEntityRepository {
    private var listener: DeleteFinancialEntityListener? = null

    override fun setListener(listener: DeleteFinancialEntityListener) = apply {
        this.listener = listener
    }

    override fun deleteFinancialEntity(id: Int) {
        datasource
            .success {
                listener?.financialEntityDeleted()
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        datasource.deleteFinancialEntity(id)
    }

    override fun cancelRequest() {
        datasource.cancel()
    }
}