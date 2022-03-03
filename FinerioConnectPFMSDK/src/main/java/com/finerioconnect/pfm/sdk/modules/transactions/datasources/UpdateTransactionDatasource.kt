package com.finerioconnect.pfm.sdk.modules.transactions.datasources

import com.finerioconnect.core.sdk.models.FCTransaction
import com.finerioconnect.core.sdk.models.requests.FCUpdateTransactionRequest
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface UpdateTransactionDatasource: BaseDatasource {

    fun success(success: (FCTransaction) -> Unit): UpdateTransactionDatasource

    fun updateTransaction(id: Int, transaction: FCUpdateTransactionRequest)

}