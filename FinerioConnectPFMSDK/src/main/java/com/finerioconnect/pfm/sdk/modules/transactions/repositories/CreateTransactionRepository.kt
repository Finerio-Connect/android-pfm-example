package com.finerioconnect.pfm.sdk.modules.transactions.repositories

import com.finerioconnect.core.sdk.models.requests.FCCreateTransactionRequest
import com.finerioconnect.pfm.sdk.modules.transactions.listeners.CreateTransactionListener

interface CreateTransactionRepository {

    fun setListener(listener: CreateTransactionListener): CreateTransactionRepository

    fun createTransaction(transaction: FCCreateTransactionRequest)

    fun cancelRequest()

}