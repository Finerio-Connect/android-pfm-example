package com.finerioconnect.pfm.sdk.modules.users.repositories

import com.finerioconnect.pfm.sdk.modules.users.listeners.DeleteUserListener

interface DeleteUserRepository {
    fun setListener(listener: DeleteUserListener): DeleteUserRepository
    fun deleteUser(id: Int)
    fun cancelRequest()
}