package com.finerioconnect.pfm.sdk.modules.accounts.repositories.impl

import com.finerioconnect.pfm.sdk.modules.accounts.datasources.DeleteAccountDatasource
import com.finerioconnect.pfm.sdk.modules.accounts.listeners.DeleteAccountListener
import com.finerioconnect.pfm.sdk.modules.accounts.repositories.DeleteAccountRepository

class DeleteAccountRepositoryImpl(
    private val deleteAccountDatasource: DeleteAccountDatasource
) : DeleteAccountRepository {

    private var listener: DeleteAccountListener? = null

    override fun setListener(listener: DeleteAccountListener) = apply {
        this.listener = listener
    }

    override fun deleteAccount(accountId: Int) {
        deleteAccountDatasource
            .success {
                listener?.accountDeleted()
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        deleteAccountDatasource.updateAccount(accountId)
    }

    override fun cancelRequest() {
        deleteAccountDatasource.cancel()
    }

}