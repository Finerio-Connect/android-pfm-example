package com.finerioconnect.pfm.sdk.modules.users.repositories.impl

import com.finerioconnect.pfm.sdk.modules.users.datasource.GetUserDatasource
import com.finerioconnect.pfm.sdk.modules.users.listeners.GetUserListener
import com.finerioconnect.pfm.sdk.modules.users.repositories.GetUserRepository

class GetUserRepositoryImpl constructor(
    private val datasource: GetUserDatasource
) : GetUserRepository {
    private var listener: GetUserListener? = null

    override fun setListener(listener: GetUserListener) = apply {
        this.listener = listener
    }

    override fun getUser(id: Int) {
        datasource
            .success {
                listener?.userObtained(it)
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        datasource.getUser(id)
    }

    override fun cancelRequest() {
        datasource.cancel()
    }
}