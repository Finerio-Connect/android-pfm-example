package com.finerioconnect.pfm.sdk.modules.accounts.repositories

import com.finerioconnect.core.sdk.models.requests.FCUpdateAccountRequest
import com.finerioconnect.pfm.sdk.modules.accounts.listeners.UpdateAccountListener

interface UpdateAccountRepository {

    fun setListener(listener: UpdateAccountListener): UpdateAccountRepository

    fun updateAccount(accountId: Int, account: FCUpdateAccountRequest)

    fun cancelRequest()

}