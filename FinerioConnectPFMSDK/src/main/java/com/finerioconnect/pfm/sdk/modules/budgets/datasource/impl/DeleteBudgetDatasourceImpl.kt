package com.finerioconnect.pfm.sdk.modules.budgets.datasource.impl

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.pfm.sdk.base.BaseDatasourceImpl
import com.finerioconnect.pfm.sdk.modules.budgets.datasource.DeleteBudgetDatasource
import com.finerioconnect.pfm.sdk.core.FinerioConnectPFMSDK

class DeleteBudgetDatasourceImpl : BaseDatasourceImpl<Unit>(), DeleteBudgetDatasource {

    override fun deleteBudget(id: Int) {
        FinerioConnectPFMSDK.shared.api.deleteBudget(getHeaders(), id).request()
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