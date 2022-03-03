package com.finerioconnect.pfm.sdk.modules.transactions.datasources

import com.finerioconnect.core.sdk.models.FCTransaction
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface GetTransactionDatasource: BaseDatasource {

    fun success(success: (FCTransaction) -> Unit): GetTransactionDatasource

    fun getTransaction(id: Int)

}