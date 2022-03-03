package com.finerioconnect.pfm.sdk.modules.categories.datasources.impl

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.responses.FCCategoriesResponse
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK
import com.finerioconnect.pfm.sdk.modules.categories.datasources.GetCategoriesDatasource

class GetCategoriesDatasourceImpl : BaseDatasourceImpl<FCCategoriesResponse>(),
    GetCategoriesDatasource {

    override fun success(success: (FCCategoriesResponse) -> Unit) = apply {
        this.success = success
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }

    override fun getCategories(userId: Int?, cursor: Int?) {
        val options = HashMap<String, String>()
        userId?.let { options["userId"] = it.toString() }
        cursor?.let { options["cursor"] = it.toString() }
        FinerioConnectPFMSDK.shared.api.getCategories(getHeaders(), options).request()
    }

}