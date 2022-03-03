package com.finerioconnect.pfm.sdk.modules.users.datasource.impl

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.FCUser
import com.finerioconnect.core.sdk.models.requests.FCCreateUserRequest
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK
import com.finerioconnect.pfm.sdk.modules.users.datasource.CreateUserDatasource

class CreateUserDatasourceImpl : BaseDatasourceImpl<FCUser>(),
    CreateUserDatasource {

    override fun createUser(user: FCCreateUserRequest) {
        FinerioConnectPFMSDK.shared.api.createUser(getJsonHeaders(), user).request()
    }

    override fun success(success: (FCUser) -> Unit) = apply {
        this.success = success
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }
}