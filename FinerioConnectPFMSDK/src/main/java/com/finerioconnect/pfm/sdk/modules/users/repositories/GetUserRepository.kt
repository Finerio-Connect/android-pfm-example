package com.finerioconnect.pfm.sdk.modules.users.repositories

import com.finerioconnect.pfm.sdk.modules.users.listeners.GetUserListener

interface GetUserRepository {
    fun setListener(listener: GetUserListener): GetUserRepository
    fun getUser(id: Int)
    fun cancelRequest()
}