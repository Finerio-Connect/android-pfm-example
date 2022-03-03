package com.finerioconnect.pfm.sdk.modules.transactions.datasources

import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface DeleteTransactionDatasource: BaseDatasource {

    fun success(success: (Any) -> Unit): DeleteTransactionDatasource

    fun deleteTransaction(id: Int)

}