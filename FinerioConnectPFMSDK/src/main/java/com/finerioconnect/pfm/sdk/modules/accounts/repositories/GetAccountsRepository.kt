package com.finerioconnect.pfm.sdk.modules.accounts.repositories

import com.finerioconnect.pfm.sdk.modules.accounts.listeners.GetAccountsListener

interface GetAccountsRepository {

    fun setListener(listener: GetAccountsListener): GetAccountsRepository

    /**
     * @param userId The ID of the user that owns the accounts.
     * @param cursor The ID of the account where the list starts.
     */
    fun getAccounts(userId: Int, cursor: Int)

    fun cancelRequest()

}