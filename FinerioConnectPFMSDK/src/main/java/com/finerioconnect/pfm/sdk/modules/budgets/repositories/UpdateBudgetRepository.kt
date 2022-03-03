package com.finerioconnect.pfm.sdk.modules.budgets.repositories

import com.finerioconnect.core.sdk.models.requests.FCUpdateBudgetRequest
import com.finerioconnect.pfm.sdk.modules.budgets.listeners.UpdateBudgetListener

interface UpdateBudgetRepository {
    fun setListener(listener: UpdateBudgetListener): UpdateBudgetRepository
    fun updateBudget(id: Int, budget: FCUpdateBudgetRequest)
    fun cancelRequest()
}