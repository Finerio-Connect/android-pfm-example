package com.finerioconnect.pfm.sdk.modules.users.repositories.impl

import com.finerioconnect.pfm.sdk.modules.users.datasource.GetUsersDatasource
import com.finerioconnect.pfm.sdk.modules.users.listeners.GetUsersListener
import com.finerioconnect.pfm.sdk.modules.users.repositories.GetUsersRepository

class GetUsersRepositoryImpl constructor(
    private val datasource: GetUsersDatasource
) : GetUsersRepository {
    private var listener: GetUsersListener? = null

    override fun setListener(listener: GetUsersListener) = apply {
        this.listener = listener
    }

    override fun getUsers(cursor: Int?) {
        datasource
            .success {
                listener?.usersObtained(it)
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        datasource.getUsers(cursor)
    }

    override fun cancelRequest() {
        datasource.cancel()
    }
}