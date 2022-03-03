package com.finerioconnect.pfm.sdk.modules.accounts.repositories.impl

import com.finerioconnect.core.sdk.models.requests.FCCreateAccountRequest
import com.finerioconnect.pfm.sdk.modules.accounts.datasources.CreateAccountDatasource
import com.finerioconnect.pfm.sdk.modules.accounts.listeners.CreateAccountListener
import com.finerioconnect.pfm.sdk.modules.accounts.repositories.CreateAccountRepository

class CreateAccountRepositoryImpl(
    private val createAccountDatasource: CreateAccountDatasource
): CreateAccountRepository {

    private var listener: CreateAccountListener?= null

    override fun setListener(listener: CreateAccountListener) = apply {
        this.listener = listener
    }

    override fun createAccount(account: FCCreateAccountRequest) {
        createAccountDatasource
            .success {
                listener?.accountCreated(it)
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        createAccountDatasource.createAccount(account)
    }

    override fun cancelRequest() {
        createAccountDatasource.cancel()
    }

}