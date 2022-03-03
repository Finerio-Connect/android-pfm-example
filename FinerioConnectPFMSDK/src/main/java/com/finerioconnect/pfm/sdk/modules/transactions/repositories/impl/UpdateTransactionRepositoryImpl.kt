package com.finerioconnect.pfm.sdk.modules.transactions.repositories.impl

import com.finerioconnect.core.sdk.models.requests.FCUpdateTransactionRequest
import com.finerioconnect.pfm.sdk.modules.transactions.datasources.UpdateTransactionDatasource
import com.finerioconnect.pfm.sdk.modules.transactions.listeners.UpdateTransactionListener
import com.finerioconnect.pfm.sdk.modules.transactions.repositories.UpdateTransactionRepository

class UpdateTransactionRepositoryImpl constructor(
    private val datasource: UpdateTransactionDatasource
): UpdateTransactionRepository {

    private var listener: UpdateTransactionListener?= null

    override fun setListener(listener: UpdateTransactionListener) = apply {
        this.listener = listener
    }

    override fun updateTransaction(id: Int, transaction: FCUpdateTransactionRequest) {
        datasource
            .success {
                listener?.transactionUpdated(it)
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        datasource.updateTransaction(id, transaction)
    }

    override fun cancelRequest() {
        datasource.cancel()
    }

}