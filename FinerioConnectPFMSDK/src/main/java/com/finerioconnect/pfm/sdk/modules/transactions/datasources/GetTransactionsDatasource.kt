package com.finerioconnect.pfm.sdk.modules.transactions.datasources

import com.finerioconnect.core.sdk.models.responses.FCTransactionsResponse
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface GetTransactionsDatasource: BaseDatasource {

    fun success(success: (FCTransactionsResponse) -> Unit): GetTransactionsDatasource

    fun getTransactions(accountId: Int, options: Map<String, String>)

}