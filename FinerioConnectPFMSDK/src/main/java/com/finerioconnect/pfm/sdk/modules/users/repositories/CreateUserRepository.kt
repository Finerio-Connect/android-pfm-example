package com.finerioconnect.pfm.sdk.modules.users.repositories

import com.finerioconnect.core.sdk.models.requests.FCCreateUserRequest
import com.finerioconnect.pfm.sdk.modules.users.listeners.CreateUserListener

interface CreateUserRepository {
    fun setListener(listener: CreateUserListener): CreateUserRepository
    fun createUser(user: FCCreateUserRequest)
    fun cancelRequest()
}