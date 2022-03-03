package com.finerioconnect.pfm.sdk.modules.accounts.listeners

import com.finerioconnect.core.sdk.models.FCAccount
import com.finerioconnect.core.sdk.models.FCError

interface CreateAccountListener {

    fun accountCreated(account: FCAccount)

    fun error(errors: List<FCError>)

    fun severError(serverError: Throwable)

}