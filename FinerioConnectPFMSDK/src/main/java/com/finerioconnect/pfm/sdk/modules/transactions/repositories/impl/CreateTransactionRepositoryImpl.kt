package com.finerioconnect.pfm.sdk.modules.transactions.repositories.impl

import com.finerioconnect.core.sdk.models.requests.FCCreateTransactionRequest
import com.finerioconnect.pfm.sdk.modules.transactions.datasources.CreateTransactionDatasource
import com.finerioconnect.pfm.sdk.modules.transactions.listeners.CreateTransactionListener
import com.finerioconnect.pfm.sdk.modules.transactions.repositories.CreateTransactionRepository

class CreateTransactionRepositoryImpl constructor(
    private val datasource: CreateTransactionDatasource
) : CreateTransactionRepository {

    private var listener: CreateTransactionListener? = null

    override fun setListener(listener: CreateTransactionListener) = apply {
        this.listener = listener
    }

    override fun createTransaction(transaction: FCCreateTransactionRequest) {
        datasource
            .success {
                listener?.transactionCreated(it)
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        datasource.createTransaction(transaction)
    }

    override fun cancelRequest() {
        datasource.cancel()
    }

}