package com.finerioconnect.pfm.sdk.modules.users.repositories.impl

import com.finerioconnect.core.sdk.models.requests.FCCreateUserRequest
import com.finerioconnect.pfm.sdk.modules.users.datasource.CreateUserDatasource
import com.finerioconnect.pfm.sdk.modules.users.listeners.CreateUserListener
import com.finerioconnect.pfm.sdk.modules.users.repositories.CreateUserRepository

class CreateUserRepositoryImpl constructor(
    private val datasource: CreateUserDatasource
) : CreateUserRepository {
    private var listener: CreateUserListener? = null

    override fun setListener(listener: CreateUserListener) = apply {
        this.listener = listener
    }

    override fun createUser(user: FCCreateUserRequest) {
        datasource
            .success {
                listener?.userCreated(it)
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        datasource.createUser(user)
    }

    override fun cancelRequest() {
        datasource.cancel()
    }
}