package com.finerioconnect.pfm.sdk.modules.accounts.datasources

import com.finerioconnect.core.sdk.models.FCAccount
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface GetAccountDatasource: BaseDatasource {

    fun success(success: (FCAccount) -> Unit): GetAccountDatasource

    fun getAccount(accountId: Int)

}