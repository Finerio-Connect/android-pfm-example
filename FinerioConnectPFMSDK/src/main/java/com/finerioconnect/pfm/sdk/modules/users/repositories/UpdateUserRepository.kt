package com.finerioconnect.pfm.sdk.modules.users.repositories

import com.finerioconnect.core.sdk.models.requests.FCUpdateUserRequest
import com.finerioconnect.pfm.sdk.modules.users.listeners.UpdateUserListener

interface UpdateUserRepository {
    fun setListener(listener: UpdateUserListener): UpdateUserRepository
    fun updateUser(id: Int, budget: FCUpdateUserRequest)
    fun cancelRequest()
}