package com.finerioconnect.pfm.sdk.modules.budgets.datasource

import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface DeleteBudgetDatasource: BaseDatasource {
    fun success(success: (Any) -> Unit): DeleteBudgetDatasource
    fun deleteBudget(id: Int)
}