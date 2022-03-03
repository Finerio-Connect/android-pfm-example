package com.finerioconnect.pfm.sdk.modules.accounts.datasources

import com.finerioconnect.core.sdk.models.responses.FCAccountsResponse
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface GetAccountsDatasource: BaseDatasource {

    fun success(success: (FCAccountsResponse) -> Unit): GetAccountsDatasource

    fun getAccounts(userId: Int, cursor: Int)

}