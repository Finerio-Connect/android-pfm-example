package com.finerioconnect.pfm.sdk.modules.users.repositories.impl

import com.finerioconnect.core.sdk.models.requests.FCUpdateUserRequest
import com.finerioconnect.pfm.sdk.modules.users.datasource.UpdateUserDataSource
import com.finerioconnect.pfm.sdk.modules.users.listeners.UpdateUserListener
import com.finerioconnect.pfm.sdk.modules.users.repositories.UpdateUserRepository

class UpdateUserRepositoryImpl constructor(
    private val datasource: UpdateUserDataSource
) : UpdateUserRepository {
    private var listener: UpdateUserListener? = null

    override fun setListener(listener: UpdateUserListener) = apply {
        this.listener = listener
    }

    override fun updateUser(id: Int, user: FCUpdateUserRequest) {
        datasource
            .success {
                listener?.userUpdated(it)
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        datasource.updateUser(id, user)
    }

    override fun cancelRequest() {
        datasource.cancel()
    }
}