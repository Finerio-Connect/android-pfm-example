package com.finerioconnect.pfm.sdk.modules.budgets.repositories

import com.finerioconnect.pfm.sdk.modules.budgets.listeners.GetBudgetsListener

interface GetBudgetsRepository {
    fun setListener(listener: GetBudgetsListener): GetBudgetsRepository
    fun getBudgets(userId: Int, cursor: Int?)
    fun cancelRequest()
}