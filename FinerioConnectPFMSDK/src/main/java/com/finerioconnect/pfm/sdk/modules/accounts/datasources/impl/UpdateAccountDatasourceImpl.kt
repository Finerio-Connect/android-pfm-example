package com.finerioconnect.pfm.sdk.modules.accounts.datasources.impl

import com.finerioconnect.core.sdk.models.FCAccount
import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.requests.FCUpdateAccountRequest
import com.finerioconnect.pfm.sdk.modules.accounts.datasources.UpdateAccountDatasource
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK

class UpdateAccountDatasourceImpl: BaseDatasourceImpl<FCAccount>(), UpdateAccountDatasource {

    override fun success(success: (FCAccount) -> Unit) = apply {
        this.success = success
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }

    override fun updateAccount(accountId: Int, account: FCUpdateAccountRequest) {
        FinerioConnectPFMSDK.shared.api.updateAccount(getJsonHeaders(), accountId, account).request()
    }

}