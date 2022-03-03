package com.finerioconnect.pfm.sdk.modules.budgets.repositories.impl

import com.finerioconnect.core.sdk.models.requests.FCCreateBudgetRequest
import com.finerioconnect.pfm.sdk.modules.budgets.datasource.CreateBudgetDatasource
import com.finerioconnect.pfm.sdk.modules.budgets.listeners.CreateBudgetListener
import com.finerioconnect.pfm.sdk.modules.budgets.repositories.CreateBudgetRepository

class CreateBudgetRepositoryImpl constructor(
    private val datasource: CreateBudgetDatasource
) : CreateBudgetRepository {
    private var listener: CreateBudgetListener? = null

    override fun setListener(listener: CreateBudgetListener) = apply {
        this.listener = listener
    }

    override fun createBudget(budget: FCCreateBudgetRequest) {
        datasource
            .success {
                listener?.budgetCreated(it)
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        datasource.createBudget(budget)
    }

    override fun cancelRequest() {
        datasource.cancel()
    }
}