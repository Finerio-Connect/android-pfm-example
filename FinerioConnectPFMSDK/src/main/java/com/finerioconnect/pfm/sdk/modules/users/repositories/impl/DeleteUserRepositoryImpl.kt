package com.finerioconnect.pfm.sdk.modules.users.repositories.impl

import com.finerioconnect.pfm.sdk.modules.users.datasource.DeleteUserDatasource
import com.finerioconnect.pfm.sdk.modules.users.listeners.DeleteUserListener
import com.finerioconnect.pfm.sdk.modules.users.repositories.DeleteUserRepository

class DeleteUserRepositoryImpl constructor(
    private val datasource: DeleteUserDatasource
) : DeleteUserRepository {
    private var listener: DeleteUserListener? = null

    override fun setListener(listener: DeleteUserListener) = apply {
        this.listener = listener
    }

    override fun deleteUser(id: Int) {
        datasource
            .success {
                listener?.userDeleted()
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        datasource.deleteUser(id)
    }

    override fun cancelRequest() {
        datasource.cancel()
    }
}