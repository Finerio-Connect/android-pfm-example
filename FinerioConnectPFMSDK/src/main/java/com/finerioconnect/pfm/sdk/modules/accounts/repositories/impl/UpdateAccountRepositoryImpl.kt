package com.finerioconnect.pfm.sdk.modules.accounts.repositories.impl

import com.finerioconnect.core.sdk.models.requests.FCUpdateAccountRequest
import com.finerioconnect.pfm.sdk.modules.accounts.datasources.UpdateAccountDatasource
import com.finerioconnect.pfm.sdk.modules.accounts.listeners.UpdateAccountListener
import com.finerioconnect.pfm.sdk.modules.accounts.repositories.UpdateAccountRepository

class UpdateAccountRepositoryImpl(
    private val updateAccountDatasource: UpdateAccountDatasource
): UpdateAccountRepository {

    private var listener: UpdateAccountListener?= null

    override fun setListener(listener: UpdateAccountListener) = apply {
        this.listener = listener
    }

    override fun updateAccount(accountId: Int, account: FCUpdateAccountRequest) {
        updateAccountDatasource
            .success {
                listener?.accountUpdated(it)
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        updateAccountDatasource.updateAccount(accountId, account)
    }

    override fun cancelRequest() {
        updateAccountDatasource.cancel()
    }
    
}