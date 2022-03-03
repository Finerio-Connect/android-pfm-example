package com.finerioconnect.pfm.sdk.modules.accounts.datasources

import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface DeleteAccountDatasource: BaseDatasource {

    fun success(success: (Any) -> Unit): DeleteAccountDatasource

    fun updateAccount(accountId: Int)

}