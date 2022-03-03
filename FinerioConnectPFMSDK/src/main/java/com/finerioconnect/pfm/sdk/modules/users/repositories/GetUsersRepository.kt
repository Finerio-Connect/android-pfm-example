package com.finerioconnect.pfm.sdk.modules.users.repositories

import com.finerioconnect.pfm.sdk.modules.users.listeners.GetUsersListener

interface GetUsersRepository {
    fun setListener(listener: GetUsersListener): GetUsersRepository
    fun getUsers(cursor: Int?)
    fun cancelRequest()
}