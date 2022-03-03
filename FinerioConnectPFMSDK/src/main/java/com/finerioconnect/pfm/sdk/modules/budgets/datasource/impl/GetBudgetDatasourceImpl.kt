package com.finerioconnect.pfm.sdk.modules.budgets.datasource.impl

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.FCBudget
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.modules.budgets.datasource.GetBudgetDatasource
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK

class GetBudgetDatasourceImpl : BaseDatasourceImpl<FCBudget>(),
    GetBudgetDatasource {

    override fun getBudget(id: Int) {
        FinerioConnectPFMSDK.shared.api.getBudget(getHeaders() ,id).request()
    }

    override fun success(success: (FCBudget) -> Unit) = apply {
        this.success = success
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }
}