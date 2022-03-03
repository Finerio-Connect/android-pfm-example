package com.finerioconnect.pfm.sdk.modules.budgets.datasource

import com.finerioconnect.core.sdk.models.requests.FCCreateBudgetRequest
import com.finerioconnect.core.sdk.models.FCBudget
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface CreateBudgetDatasource : BaseDatasource {
    fun success(success: (FCBudget) -> Unit): CreateBudgetDatasource
    fun createBudget(budget: FCCreateBudgetRequest)
}