package com.finerioconnect.pfm.sdk.modules.budgets.repositories.impl

import com.finerioconnect.core.sdk.models.requests.FCUpdateBudgetRequest
import com.finerioconnect.pfm.sdk.modules.budgets.datasource.UpdateBudgetDatasource
import com.finerioconnect.pfm.sdk.modules.budgets.listeners.UpdateBudgetListener
import com.finerioconnect.pfm.sdk.modules.budgets.repositories.UpdateBudgetRepository

class UpdateBudgetRepositoryImpl constructor(
    private val datasource: UpdateBudgetDatasource
) : UpdateBudgetRepository {
    private var listener: UpdateBudgetListener? = null

    override fun setListener(listener: UpdateBudgetListener) = apply {
        this.listener = listener
    }

    override fun updateBudget(id: Int, budget: FCUpdateBudgetRequest) {
        datasource
            .success {
                listener?.budgetUpdated(it)
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        datasource.updateBudget(id, budget)
    }

    override fun cancelRequest() {
        datasource.cancel()
    }
}