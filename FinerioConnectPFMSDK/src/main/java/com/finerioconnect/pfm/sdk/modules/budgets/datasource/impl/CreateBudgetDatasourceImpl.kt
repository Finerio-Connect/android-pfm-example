package com.finerioconnect.pfm.sdk.modules.budgets.datasource.impl

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.requests.FCCreateBudgetRequest
import com.finerioconnect.core.sdk.models.FCBudget
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.modules.budgets.datasource.CreateBudgetDatasource
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK

class CreateBudgetDatasourceImpl : BaseDatasourceImpl<FCBudget>(),
    CreateBudgetDatasource {

    override fun createBudget(budget: FCCreateBudgetRequest) {
        FinerioConnectPFMSDK.shared.api.createBudget(getJsonHeaders(), budget).request()
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