package com.finerioconnect.pfm.sdk.modules.budgets.repositories

import com.finerioconnect.pfm.sdk.modules.budgets.listeners.DeleteBudgetListener

interface DeleteBudgetRepository {
    fun setListener(listener: DeleteBudgetListener): DeleteBudgetRepository
    fun deleteBudget(id: Int)
    fun cancelRequest()
}