package com.finerioconnect.pfm.sdk.modules.users.listeners

import com.finerioconnect.core.sdk.models.FCError

interface DeleteUserListener {
    fun userDeleted()
    fun error(errors: List<FCError>)
    fun severError(serverError: Throwable)
}