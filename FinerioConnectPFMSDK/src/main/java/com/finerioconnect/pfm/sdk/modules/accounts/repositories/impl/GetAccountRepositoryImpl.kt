package com.finerioconnect.pfm.sdk.modules.accounts.repositories.impl

import com.finerioconnect.pfm.sdk.modules.accounts.datasources.GetAccountDatasource
import com.finerioconnect.pfm.sdk.modules.accounts.listeners.GetAccountListener
import com.finerioconnect.pfm.sdk.modules.accounts.repositories.GetAccountRepository

class GetAccountRepositoryImpl(
    private val getAccountDatasource: GetAccountDatasource
) : GetAccountRepository {

    private var listener: GetAccountListener? = null

    override fun setListener(listener: GetAccountListener) = apply {
        this.listener = listener
    }

    override fun getAccount(accountId: Int) {
        getAccountDatasource
            .success {
                listener?.account(it)
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        getAccountDatasource.getAccount(accountId)
    }

    override fun cancelRequest() {
        TODO("Not yet implemented")
    }
}