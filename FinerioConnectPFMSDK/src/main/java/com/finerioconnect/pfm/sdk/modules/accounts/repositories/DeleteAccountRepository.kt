package com.finerioconnect.pfm.sdk.modules.accounts.repositories

import com.finerioconnect.pfm.sdk.modules.accounts.listeners.DeleteAccountListener

interface DeleteAccountRepository {

    fun setListener(listener: DeleteAccountListener): DeleteAccountRepository

    fun deleteAccount(accountId: Int)

    fun cancelRequest()

}