package com.finerioconnect.pfm.sdk.modules.users.datasource.impl

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.responses.FCUsersResponse
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK
import com.finerioconnect.pfm.sdk.modules.users.datasource.GetUsersDatasource

class GetUsersDatasourceImpl : BaseDatasourceImpl<FCUsersResponse>(),
    GetUsersDatasource {

    override fun getUsers(cursor: Int?) {
        FinerioConnectPFMSDK.shared.api.getUsers(getHeaders(), cursor).request()
    }

    override fun success(success: (FCUsersResponse) -> Unit) = apply {
        this.success = success
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }
}