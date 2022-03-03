package com.finerioconnect.pfm.sdk.modules.users.listeners

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.FCUser

interface CreateUserListener {
    fun userCreated(user: FCUser)
    fun error(errors: List<FCError>)
    fun severError(serverError: Throwable)
}