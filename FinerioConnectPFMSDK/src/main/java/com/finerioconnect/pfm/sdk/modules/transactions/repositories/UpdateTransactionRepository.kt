package com.finerioconnect.pfm.sdk.modules.transactions.repositories

import com.finerioconnect.core.sdk.models.requests.FCUpdateTransactionRequest
import com.finerioconnect.pfm.sdk.modules.transactions.listeners.UpdateTransactionListener

interface UpdateTransactionRepository {

    fun setListener(listener: UpdateTransactionListener): UpdateTransactionRepository

    fun updateTransaction(id: Int, transaction: FCUpdateTransactionRequest)

    fun cancelRequest()

}