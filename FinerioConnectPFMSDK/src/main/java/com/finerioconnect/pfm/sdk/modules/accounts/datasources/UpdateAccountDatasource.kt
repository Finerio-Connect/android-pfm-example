package com.finerioconnect.pfm.sdk.modules.accounts.datasources

import com.finerioconnect.core.sdk.models.FCAccount
import com.finerioconnect.core.sdk.models.requests.FCUpdateAccountRequest
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface UpdateAccountDatasource: BaseDatasource {

    fun success(success: (FCAccount) -> Unit): UpdateAccountDatasource

    fun updateAccount(accountId: Int, account: FCUpdateAccountRequest)

}