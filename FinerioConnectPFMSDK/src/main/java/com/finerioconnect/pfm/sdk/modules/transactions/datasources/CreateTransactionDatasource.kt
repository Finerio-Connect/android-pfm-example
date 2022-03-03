package com.finerioconnect.pfm.sdk.modules.transactions.datasources

import com.finerioconnect.core.sdk.models.FCTransaction
import com.finerioconnect.core.sdk.models.requests.FCCreateTransactionRequest
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface CreateTransactionDatasource: BaseDatasource {

    fun success(success: (FCTransaction) -> Unit): CreateTransactionDatasource

    fun createTransaction(transaction: FCCreateTransactionRequest)

}