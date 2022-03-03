package com.finerioconnect.pfm.sdk.modules.users.datasource

import com.finerioconnect.core.sdk.models.responses.FCUsersResponse
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface GetUsersDatasource : BaseDatasource {
    fun success(success: (FCUsersResponse) -> Unit): GetUsersDatasource
    fun getUsers(cursor: Int?)
}