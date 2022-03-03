package com.finerioconnect.pfm.sdk.modules.accounts.repositories

import com.finerioconnect.core.sdk.models.requests.FCCreateAccountRequest
import com.finerioconnect.pfm.sdk.modules.accounts.listeners.CreateAccountListener

interface CreateAccountRepository {

    fun setListener(listener: CreateAccountListener): CreateAccountRepository

    fun createAccount(account: FCCreateAccountRequest)

    fun cancelRequest()

}