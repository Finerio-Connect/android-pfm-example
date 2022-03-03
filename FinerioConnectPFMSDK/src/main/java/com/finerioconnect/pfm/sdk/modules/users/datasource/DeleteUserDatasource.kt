package com.finerioconnect.pfm.sdk.modules.users.datasource

import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface DeleteUserDatasource : BaseDatasource {
    fun success(success: (Any) -> Unit): DeleteUserDatasource
    fun deleteUser(id: Int)
}