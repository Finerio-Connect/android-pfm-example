package com.finerioconnect.pfm.sdk.modules.budgets.datasource.impl

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.responses.FCBudgetsResponse
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.modules.budgets.datasource.GetBudgetsDatasource
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK

class GetBudgetsDatasourceImpl : BaseDatasourceImpl<FCBudgetsResponse>(),
    GetBudgetsDatasource {

    override fun getBudgets(userId: Int, cursor: Int?) {
        FinerioConnectPFMSDK.shared.api.getBudgets(getHeaders(), userId, cursor).request()
    }

    override fun success(success: (FCBudgetsResponse) -> Unit) = apply {
        this.success = success
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }
}