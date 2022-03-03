package com.finerioconnect.pfm.sdk.modules.budgets.repositories

import com.finerioconnect.core.sdk.models.requests.FCCreateBudgetRequest
import com.finerioconnect.pfm.sdk.modules.budgets.listeners.CreateBudgetListener

interface CreateBudgetRepository {
    fun setListener(listener: CreateBudgetListener): CreateBudgetRepository
    fun createBudget(budget: FCCreateBudgetRequest)
    fun cancelRequest()
}