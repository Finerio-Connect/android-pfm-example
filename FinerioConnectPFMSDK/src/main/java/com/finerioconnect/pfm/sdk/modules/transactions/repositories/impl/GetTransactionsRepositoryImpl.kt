package com.finerioconnect.pfm.sdk.modules.transactions.repositories.impl

import com.finerioconnect.pfm.sdk.modules.transactions.datasources.GetTransactionsDatasource
import com.finerioconnect.pfm.sdk.modules.transactions.listeners.GetTransactionsListener
import com.finerioconnect.pfm.sdk.modules.transactions.repositories.GetTransactionsRepository

class GetTransactionsRepositoryImpl(
    private val datasource: GetTransactionsDatasource
) : GetTransactionsRepository {

    private var listener: GetTransactionsListener? = null

    override fun setListener(listener: GetTransactionsListener) = apply {
        this.listener = listener
    }

    override fun getTransactions(accountId: Int, options: Map<String, String>) {
        datasource
            .success {
                listener?.transactions(it.data ?: arrayListOf(), it.nextCursor ?: 0)
            }.error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        datasource.getTransactions(accountId, options)
    }

    override fun cancelRequest() {
        datasource.cancel()
    }

}