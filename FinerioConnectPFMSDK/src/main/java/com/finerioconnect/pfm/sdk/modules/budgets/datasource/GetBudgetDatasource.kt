package com.finerioconnect.pfm.sdk.modules.budgets.datasource

import com.finerioconnect.core.sdk.models.FCBudget
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface GetBudgetDatasource: BaseDatasource {
    fun success(success: (FCBudget) -> Unit): GetBudgetDatasource
    fun getBudget(id: Int)
}