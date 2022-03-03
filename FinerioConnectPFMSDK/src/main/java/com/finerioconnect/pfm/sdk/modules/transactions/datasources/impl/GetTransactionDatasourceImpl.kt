package com.finerioconnect.pfm.sdk.modules.transactions.datasources.impl

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.FCTransaction
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK
import com.finerioconnect.pfm.sdk.modules.transactions.datasources.GetTransactionDatasource

class GetTransactionDatasourceImpl : BaseDatasourceImpl<FCTransaction>(),
    GetTransactionDatasource {

    override fun success(success: (FCTransaction) -> Unit) = apply {
        this.success = success
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }

    override fun getTransaction(id: Int) {
        FinerioConnectPFMSDK.shared.api.getTransaction(getHeaders(), id).request()
    }

}