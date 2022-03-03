package com.finerioconnect.pfm.sdk.modules.budgets.datasource.impl

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.requests.FCUpdateBudgetRequest
import com.finerioconnect.core.sdk.models.FCBudget
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.modules.budgets.datasource.UpdateBudgetDatasource
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK

class UpdateBudgetDatasourceImpl : BaseDatasourceImpl<FCBudget>(),
    UpdateBudgetDatasource {

    override fun success(success: (FCBudget) -> Unit) = apply {
        this.success = success
    }

    override fun updateBudget(id: Int, updateBudgetRequest: FCUpdateBudgetRequest) {
        FinerioConnectPFMSDK.shared.api.updateBudget(getHeaders(), id, updateBudgetRequest).request()
    }

    override fun error(error: (List<FCError>) -> Unit) = apply {
        this.error = error
    }

    override fun severError(serverError: (Throwable) -> Unit) = apply {
        this.serverError = serverError
    }
}