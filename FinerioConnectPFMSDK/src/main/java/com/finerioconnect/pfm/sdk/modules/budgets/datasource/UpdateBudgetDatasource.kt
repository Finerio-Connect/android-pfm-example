package com.finerioconnect.pfm.sdk.modules.budgets.datasource

import com.finerioconnect.core.sdk.models.requests.FCUpdateBudgetRequest
import com.finerioconnect.core.sdk.models.FCBudget
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface UpdateBudgetDatasource: BaseDatasource {
    fun success(success: (FCBudget) -> Unit): UpdateBudgetDatasource
    fun updateBudget(id: Int, updateBudgetRequest: FCUpdateBudgetRequest)
}