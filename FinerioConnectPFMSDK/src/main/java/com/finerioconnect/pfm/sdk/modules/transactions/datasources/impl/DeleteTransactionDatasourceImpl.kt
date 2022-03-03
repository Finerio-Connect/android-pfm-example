package com.finerioconnect.pfm.sdk.modules.transactions.datasources.impl

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK
import com.finerioconnect.pfm.sdk.modules.transactions.datasources.DeleteTransactionDatasource

class DeleteTransactionDatasourceImpl : BaseDatasourceImpl<Unit>(), DeleteTransactionDatasource {

    override fun success(success: (Any) -> Unit) = apply {
        this.success = success
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }

    override fun deleteTransaction(id: Int) {
        FinerioConnectPFMSDK.shared.api.deleteTransaction(getHeaders(), id).request()
    }

}