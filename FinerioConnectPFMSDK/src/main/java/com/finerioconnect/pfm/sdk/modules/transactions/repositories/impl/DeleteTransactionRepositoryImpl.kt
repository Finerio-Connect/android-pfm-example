package com.finerioconnect.pfm.sdk.modules.transactions.repositories.impl

import com.finerioconnect.pfm.sdk.modules.transactions.datasources.DeleteTransactionDatasource
import com.finerioconnect.pfm.sdk.modules.transactions.listeners.DeleteTransactionListener
import com.finerioconnect.pfm.sdk.modules.transactions.repositories.DeleteTransactionRepository

class DeleteTransactionRepositoryImpl constructor(
    private val datasource: DeleteTransactionDatasource
): DeleteTransactionRepository {

    private var listener: DeleteTransactionListener?= null

    override fun setListener(listener: DeleteTransactionListener) = apply {
        this.listener = listener
    }

    override fun deleteTransaction(id: Int) {
        datasource
            .success {
                listener?.transactionDeleted()
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        datasource.deleteTransaction(id)
    }

    override fun cancelRequest() {
        datasource.cancel()
    }

}