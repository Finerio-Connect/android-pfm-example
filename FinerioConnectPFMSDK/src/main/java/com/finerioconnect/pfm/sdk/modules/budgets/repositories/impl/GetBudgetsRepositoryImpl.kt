package com.finerioconnect.pfm.sdk.modules.budgets.repositories.impl

import com.finerioconnect.pfm.sdk.modules.budgets.datasource.GetBudgetsDatasource
import com.finerioconnect.pfm.sdk.modules.budgets.listeners.GetBudgetsListener
import com.finerioconnect.pfm.sdk.modules.budgets.repositories.GetBudgetsRepository

class GetBudgetsRepositoryImpl constructor(
    private val datasource: GetBudgetsDatasource
) : GetBudgetsRepository {
    private var listener: GetBudgetsListener? = null

    override fun setListener(listener: GetBudgetsListener) = apply {
        this.listener = listener
    }

    override fun getBudgets(userId: Int, cursor: Int?) {
        datasource
            .success {
                listener?.budgetsObtained(it)
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        datasource.getBudgets(userId, cursor)
    }

    override fun cancelRequest() {
        datasource.cancel()
    }
}