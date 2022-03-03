package com.finerioconnect.pfm.sdk.modules.users.datasource.impl

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.FCUser
import com.finerioconnect.core.sdk.models.requests.FCUpdateUserRequest
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK
import com.finerioconnect.pfm.sdk.modules.users.datasource.UpdateUserDataSource

class UpdateUserDataSourceImpl : BaseDatasourceImpl<FCUser>(),
    UpdateUserDataSource {

    override fun success(success: (FCUser) -> Unit) = apply {
        this.success = success
    }

    override fun updateUser(id: Int, updateUserRequest: FCUpdateUserRequest) {
        FinerioConnectPFMSDK.shared.api.updateUser(getHeaders(), id, updateUserRequest).request()
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }
}