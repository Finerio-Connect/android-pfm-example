package com.finerioconnect.pfm.sdk.modules.users

import com.finerioconnect.core.sdk.models.requests.FCCreateUserRequest
import com.finerioconnect.core.sdk.models.requests.FCUpdateUserRequest
import com.finerioconnect.pfm.sdk.modules.users.datasource.impl.*
import com.finerioconnect.pfm.sdk.modules.users.listeners.*
import com.finerioconnect.pfm.sdk.modules.users.repositories.impl.*

class UsersDataManager {
    fun create(user: FCCreateUserRequest, listener: CreateUserListener) {
        CreateUserRepositoryImpl(CreateUserDatasourceImpl())
            .setListener(listener)
            .createUser(user)
    }

    fun getAll(cursor: Int?, listener: GetUsersListener) {
        GetUsersRepositoryImpl(GetUsersDatasourceImpl())
            .setListener(listener)
            .getUsers(cursor)
    }

    fun get(id: Int, listener: GetUserListener) {
        GetUserRepositoryImpl(GetUserDatasourceImpl())
            .setListener(listener)
            .getUser(id)
    }

    fun update(id: Int, budget: FCUpdateUserRequest, listener: UpdateUserListener) {
        UpdateUserRepositoryImpl(UpdateUserDataSourceImpl())
            .setListener(listener)
            .updateUser(id, budget)
    }

    fun delete(id: Int, listener: DeleteUserListener) {
        DeleteUserRepositoryImpl(DeleteUserDatasourceImpl())
            .setListener(listener)
            .deleteUser(id)
    }
}