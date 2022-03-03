package com.finerioconnect.pfm.sdk.modules.accounts.listeners

import com.finerioconnect.core.sdk.models.FCError

interface DeleteAccountListener {

    fun accountDeleted()

    fun error(errors: List<FCError>)

    fun severError(serverError: Throwable)

}