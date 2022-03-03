package com.finerioconnect.pfm.sdk.modules.budgets.repositories

import com.finerioconnect.pfm.sdk.modules.budgets.listeners.GetBudgetListener

interface GetBudgetRepository {
    fun setListener(listener: GetBudgetListener): GetBudgetRepository
    fun getBudget(id: Int)
    fun cancelRequest()
}