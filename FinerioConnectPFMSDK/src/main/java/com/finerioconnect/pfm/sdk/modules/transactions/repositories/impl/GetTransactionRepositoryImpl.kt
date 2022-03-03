package com.finerioconnect.pfm.sdk.modules.transactions.repositories.impl

import com.finerioconnect.pfm.sdk.modules.transactions.datasources.GetTransactionDatasource
import com.finerioconnect.pfm.sdk.modules.transactions.listeners.GetTransactionListener
import com.finerioconnect.pfm.sdk.modules.transactions.repositories.GetTransactionRepository

class GetTransactionRepositoryImpl constructor(
    private val getTransactionDatasource: GetTransactionDatasource
): GetTransactionRepository {

    private var listener: GetTransactionListener?= null

    override fun setListener(listener: GetTransactionListener) = apply {
        this.listener = listener
    }

    override fun getTransaction(id: Int) {
        getTransactionDatasource
            .success {
                listener?.transaction(it)
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        getTransactionDatasource.getTransaction(id)
    }

    override fun cancelRequest() {
        getTransactionDatasource.cancel()
    }

}