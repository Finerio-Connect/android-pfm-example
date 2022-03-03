package com.finerioconnect.pfm.sdk.modules.users.datasource

import com.finerioconnect.core.sdk.models.FCUser
import com.finerioconnect.core.sdk.models.requests.FCCreateUserRequest
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface CreateUserDatasource : BaseDatasource {
    fun success(success: (FCUser) -> Unit): CreateUserDatasource
    fun createUser(user: FCCreateUserRequest)
}