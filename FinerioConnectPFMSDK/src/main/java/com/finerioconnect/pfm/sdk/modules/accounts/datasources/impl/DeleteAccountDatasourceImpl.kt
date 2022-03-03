package com.finerioconnect.pfm.sdk.modules.accounts.datasources.impl

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.pfm.sdk.modules.accounts.datasources.DeleteAccountDatasource
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK

class DeleteAccountDatasourceImpl: BaseDatasourceImpl<Unit>(), DeleteAccountDatasource {

    override fun success(success: (Any) -> Unit) = apply {
        this.success = success
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }

    override fun updateAccount(accountId: Int) {
        FinerioConnectPFMSDK.shared.api.deleteAccount(getHeaders(), accountId).request()
    }

}