package com.finerioconnect.pfm.sdk.modules.budgets.repositories.impl

import com.finerioconnect.pfm.sdk.modules.budgets.datasource.GetBudgetDatasource
import com.finerioconnect.pfm.sdk.modules.budgets.listeners.GetBudgetListener
import com.finerioconnect.pfm.sdk.modules.budgets.repositories.GetBudgetRepository

class GetBudgetRepositoryImpl constructor(
    private val datasource: GetBudgetDatasource
) : GetBudgetRepository {
    private var listener: GetBudgetListener? = null

    override fun setListener(listener: GetBudgetListener) = apply {
        this.listener = listener
    }

    override fun getBudget(id: Int) {
        datasource
            .success {
                listener?.budgetObtained(it)
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        datasource.getBudget(id)
    }

    override fun cancelRequest() {
        datasource.cancel()
    }
}