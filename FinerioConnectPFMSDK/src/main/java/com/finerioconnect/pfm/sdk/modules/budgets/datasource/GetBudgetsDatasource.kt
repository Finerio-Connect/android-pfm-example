package com.finerioconnect.pfm.sdk.modules.budgets.datasource

import com.finerioconnect.core.sdk.models.responses.FCBudgetsResponse
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface GetBudgetsDatasource: BaseDatasource {
    fun success(success: (FCBudgetsResponse) -> Unit): GetBudgetsDatasource
    fun getBudgets(userId: Int, cursor: Int?)
}