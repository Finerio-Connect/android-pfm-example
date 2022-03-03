package com.finerioconnect.pfm.sdk.modules.transactions.repositories

import com.finerioconnect.pfm.sdk.modules.transactions.listeners.DeleteTransactionListener

interface DeleteTransactionRepository {

    fun setListener(listener: DeleteTransactionListener): DeleteTransactionRepository

    fun deleteTransaction(id: Int)

    fun cancelRequest()

}