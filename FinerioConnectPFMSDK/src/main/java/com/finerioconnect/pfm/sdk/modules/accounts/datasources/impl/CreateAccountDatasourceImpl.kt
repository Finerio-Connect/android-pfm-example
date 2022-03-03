package com.finerioconnect.pfm.sdk.modules.accounts.datasources.impl

import com.finerioconnect.core.sdk.models.FCAccount
import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.requests.FCCreateAccountRequest
import com.finerioconnect.pfm.sdk.modules.accounts.datasources.CreateAccountDatasource
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK

class CreateAccountDatasourceImpl: BaseDatasourceImpl<FCAccount>(), CreateAccountDatasource {

    override fun success(success: (FCAccount) -> Unit) = apply {
        this.success = success
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }

    override fun createAccount(account: FCCreateAccountRequest) {
        FinerioConnectPFMSDK.shared.api.createAccount(getJsonHeaders(), account).request()
    }

}