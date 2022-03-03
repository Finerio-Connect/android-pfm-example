package com.finerioconnect.pfm.sdk.modules.users.datasource

import com.finerioconnect.core.sdk.models.FCUser
import com.finerioconnect.core.sdk.models.requests.FCUpdateUserRequest
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface UpdateUserDataSource : BaseDatasource {
    fun success(success: (FCUser) -> Unit): UpdateUserDataSource
    fun updateUser(id: Int, updateUserRequest: FCUpdateUserRequest)
}