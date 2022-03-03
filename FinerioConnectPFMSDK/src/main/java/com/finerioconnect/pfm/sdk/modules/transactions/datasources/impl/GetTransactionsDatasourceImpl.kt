package com.finerioconnect.pfm.sdk.modules.transactions.datasources.impl

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.responses.FCTransactionsResponse
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK
import com.finerioconnect.pfm.sdk.modules.transactions.datasources.GetTransactionsDatasource

class GetTransactionsDatasourceImpl : BaseDatasourceImpl<FCTransactionsResponse>(),
    GetTransactionsDatasource {

    override fun success(success: (FCTransactionsResponse) -> Unit) = apply {
        this.success = success
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }

    override fun getTransactions(accountId: Int, options: Map<String, String>) {
        FinerioConnectPFMSDK.shared.api.getTransactions(getHeaders(),accountId, options).request()
    }

}