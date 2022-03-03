package com.finerioconnect.pfm.sdk.modules.transactions.datasources.impl

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.FCTransaction
import com.finerioconnect.core.sdk.models.requests.FCCreateTransactionRequest
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK
import com.finerioconnect.pfm.sdk.modules.transactions.datasources.CreateTransactionDatasource

class CreateTransactionDatasourceImpl : BaseDatasourceImpl<FCTransaction>(),
    CreateTransactionDatasource {

    override fun success(success: (FCTransaction) -> Unit) = apply {
        this.success = success
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }

    override fun createTransaction(transaction: FCCreateTransactionRequest) {
        FinerioConnectPFMSDK.shared.api.createTransaction(getJsonHeaders(), transaction).request()
    }

}