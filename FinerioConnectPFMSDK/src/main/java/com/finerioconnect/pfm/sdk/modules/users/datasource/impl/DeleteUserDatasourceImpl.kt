package com.finerioconnect.pfm.sdk.modules.users.datasource.impl

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK
import com.finerioconnect.pfm.sdk.modules.users.datasource.DeleteUserDatasource

class DeleteUserDatasourceImpl : BaseDatasourceImpl<Unit>(), DeleteUserDatasource {

    override fun deleteUser(id: Int) {
        FinerioConnectPFMSDK.shared.api.deleteUser(getHeaders(), id).request()
    }

    override fun success(success: (Any) -> Unit) = apply {
        this.success = success
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }
}