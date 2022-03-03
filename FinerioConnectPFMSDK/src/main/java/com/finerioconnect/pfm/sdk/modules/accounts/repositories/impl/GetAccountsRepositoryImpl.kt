package com.finerioconnect.pfm.sdk.modules.accounts.repositories.impl

import com.finerioconnect.pfm.sdk.modules.accounts.datasources.GetAccountsDatasource
import com.finerioconnect.pfm.sdk.modules.accounts.listeners.GetAccountsListener
import com.finerioconnect.pfm.sdk.modules.accounts.repositories.GetAccountsRepository

class GetAccountsRepositoryImpl(
    private val getAccountsDatasource: GetAccountsDatasource
) : GetAccountsRepository {

    private var listener: GetAccountsListener? = null

    override fun setListener(listener: GetAccountsListener) = apply {
        this.listener = listener
    }

    override fun getAccounts(userId: Int, cursor: Int) {
        getAccountsDatasource
            .success {
                listener?.accounts(it.data ?: arrayListOf(), it.nextCursor ?: 0)
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        getAccountsDatasource.getAccounts(userId, cursor)
    }

    override fun cancelRequest() {
        getAccountsDatasource.cancel()
    }

}