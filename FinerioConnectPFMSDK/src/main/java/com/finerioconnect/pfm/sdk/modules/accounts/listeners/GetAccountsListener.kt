package com.finerioconnect.pfm.sdk.modules.accounts.listeners

import com.finerioconnect.core.sdk.models.FCAccount
import com.finerioconnect.core.sdk.models.FCError

interface GetAccountsListener {

    fun accounts(accounts: List<FCAccount>, nextCursor: Int)

    fun error(errors: List<FCError>)

    fun severError(serverError: Throwable)

}