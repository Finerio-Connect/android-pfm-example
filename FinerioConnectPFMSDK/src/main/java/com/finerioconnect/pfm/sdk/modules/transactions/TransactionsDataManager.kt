package com.finerioconnect.pfm.sdk.modules.transactions

import com.finerioconnect.core.sdk.models.requests.FCCreateTransactionRequest
import com.finerioconnect.core.sdk.models.requests.FCUpdateTransactionRequest
import com.finerioconnect.pfm.sdk.modules.transactions.datasources.impl.*
import com.finerioconnect.pfm.sdk.modules.transactions.listeners.*
import com.finerioconnect.pfm.sdk.modules.transactions.repositories.impl.*

class TransactionsDataManager {

    fun create(transaction: FCCreateTransactionRequest, listener: CreateTransactionListener){
        CreateTransactionRepositoryImpl(CreateTransactionDatasourceImpl())
            .setListener(listener)
            .createTransaction(transaction)
    }

    fun getAll(accountId: Int, options: Map<String, String>, listener: GetTransactionsListener){
        GetTransactionsRepositoryImpl(GetTransactionsDatasourceImpl())
            .setListener(listener)
            .getTransactions(accountId, options)
    }

    fun get(transactionId: Int, listener: GetTransactionListener){
        GetTransactionRepositoryImpl(GetTransactionDatasourceImpl())
            .setListener(listener)
            .getTransaction(transactionId)
    }

    fun update(transactionId: Int, transaction: FCUpdateTransactionRequest, listener: UpdateTransactionListener){
        UpdateTransactionRepositoryImpl(UpdateTransactionDatasourceImpl())
            .setListener(listener)
            .updateTransaction(transactionId, transaction)
    }

    fun delete(transactionId: Int, listener: DeleteTransactionListener){
        DeleteTransactionRepositoryImpl(DeleteTransactionDatasourceImpl())
            .setListener(listener)
            .deleteTransaction(transactionId)
    }

}