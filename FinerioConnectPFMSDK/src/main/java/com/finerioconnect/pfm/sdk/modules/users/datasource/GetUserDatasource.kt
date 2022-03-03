package com.finerioconnect.pfm.sdk.modules.users.datasource

import com.finerioconnect.core.sdk.models.FCUser
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface GetUserDatasource : BaseDatasource {
    fun success(success: (FCUser) -> Unit): GetUserDatasource
    fun getUser(id: Int)
}