package com.finerioconnect.pfm.sdk.modules.accounts.datasources.impl

import com.finerioconnect.core.sdk.models.FCAccount
import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.pfm.sdk.modules.accounts.datasources.GetAccountDatasource
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK

class GetAccountDatasourceImpl: BaseDatasourceImpl<FCAccount>(), GetAccountDatasource {

    override fun success(success: (FCAccount) -> Unit) = apply {
        this.success = success
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }

    override fun getAccount(accountId: Int) {
        FinerioConnectPFMSDK.shared.api.getAccount(getHeaders(), accountId).request()
    }

}