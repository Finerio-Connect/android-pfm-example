package com.finerioconnect.pfm.sdk.modules.accounts.datasources.impl

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.responses.FCAccountsResponse
import com.finerioconnect.pfm.sdk.modules.accounts.datasources.GetAccountsDatasource
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK

class GetAccountsDatasourceImpl: BaseDatasourceImpl<FCAccountsResponse>(), GetAccountsDatasource {

    override fun success(success: (FCAccountsResponse) -> Unit) = apply {
        this.success = success
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }

    override fun getAccounts(userId: Int, cursor: Int) {
        FinerioConnectPFMSDK.shared.api.getAccounts(getHeaders(), userId, cursor).request()
    }

}