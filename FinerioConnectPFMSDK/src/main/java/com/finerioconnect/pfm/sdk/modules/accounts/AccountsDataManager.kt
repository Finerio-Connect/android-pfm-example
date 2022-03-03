package com.finerioconnect.pfm.sdk.modules.accounts

import com.finerioconnect.core.sdk.models.requests.FCCreateAccountRequest
import com.finerioconnect.core.sdk.models.requests.FCUpdateAccountRequest
import com.finerioconnect.pfm.sdk.modules.accounts.datasources.impl.*
import com.finerioconnect.pfm.sdk.modules.accounts.listeners.*
import com.finerioconnect.pfm.sdk.modules.accounts.repositories.impl.*

class AccountsDataManager {

    fun create(account: FCCreateAccountRequest, listener: CreateAccountListener){
        CreateAccountRepositoryImpl(CreateAccountDatasourceImpl())
            .setListener(listener)
            .createAccount(account)
    }

    fun getAll(userId: Int, cursor: Int, listener: GetAccountsListener){
        GetAccountsRepositoryImpl(GetAccountsDatasourceImpl())
            .setListener(listener)
            .getAccounts(userId, cursor)
    }

    fun get(accountId: Int, listener: GetAccountListener){
        GetAccountRepositoryImpl(GetAccountDatasourceImpl())
            .setListener(listener)
            .getAccount(accountId)
    }

    fun update(accountId: Int, account: FCUpdateAccountRequest, listener: UpdateAccountListener){
        UpdateAccountRepositoryImpl(UpdateAccountDatasourceImpl())
            .setListener(listener)
            .updateAccount(accountId, account)
    }

    fun delete(accountId: Int, listener: DeleteAccountListener){
        DeleteAccountRepositoryImpl(DeleteAccountDatasourceImpl())
            .setListener(listener)
            .deleteAccount(accountId)
    }

}