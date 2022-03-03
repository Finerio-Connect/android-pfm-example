package com.finerioconnect.pfm.sdk.modules.users.listeners

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.responses.FCUsersResponse

interface GetUsersListener {
    fun usersObtained(users: FCUsersResponse)
    fun error(errors: List<FCError>)
    fun severError(serverError: Throwable)
}