package com.finerioconnect.pfm.sdk.modules.accounts.datasources

import com.finerioconnect.core.sdk.models.FCAccount
import com.finerioconnect.core.sdk.models.requests.FCCreateAccountRequest
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface CreateAccountDatasource: BaseDatasource {

    fun success(success: (FCAccount) -> Unit): CreateAccountDatasource

    fun createAccount(account: FCCreateAccountRequest)

}