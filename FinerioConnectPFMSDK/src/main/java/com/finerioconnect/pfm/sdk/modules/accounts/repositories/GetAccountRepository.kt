package com.finerioconnect.pfm.sdk.modules.accounts.repositories

import com.finerioconnect.pfm.sdk.modules.accounts.listeners.GetAccountListener

interface GetAccountRepository {

    fun setListener(listener: GetAccountListener): GetAccountRepository

    /**
     * @param accountId The ID of the account to request.
     */
    fun getAccount(accountId: Int)

    fun cancelRequest()

}