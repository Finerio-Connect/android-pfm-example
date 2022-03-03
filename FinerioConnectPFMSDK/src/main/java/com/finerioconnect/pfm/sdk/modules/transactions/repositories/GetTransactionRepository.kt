package com.finerioconnect.pfm.sdk.modules.transactions.repositories

import com.finerioconnect.pfm.sdk.modules.transactions.listeners.GetTransactionListener

interface GetTransactionRepository {

    fun setListener(listener: GetTransactionListener): GetTransactionRepository

    fun getTransaction(id: Int)

    fun cancelRequest()

}