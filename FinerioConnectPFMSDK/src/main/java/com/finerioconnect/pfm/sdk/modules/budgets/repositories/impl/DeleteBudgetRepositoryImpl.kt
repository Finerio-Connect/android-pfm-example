package com.finerioconnect.pfm.sdk.modules.budgets.repositories.impl

import com.finerioconnect.pfm.sdk.modules.budgets.datasource.DeleteBudgetDatasource
import com.finerioconnect.pfm.sdk.modules.budgets.listeners.DeleteBudgetListener
import com.finerioconnect.pfm.sdk.modules.budgets.repositories.DeleteBudgetRepository

class DeleteBudgetRepositoryImpl constructor(
    private val datasource: DeleteBudgetDatasource
) : DeleteBudgetRepository {
    private var listener: DeleteBudgetListener? = null

    override fun setListener(listener: DeleteBudgetListener) = apply {
        this.listener = listener
    }

    override fun deleteBudget(id: Int) {
        datasource
            .success {
                listener?.budgetDeleted()
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        datasource.deleteBudget(id)
    }

    override fun cancelRequest() {
        datasource.cancel()
    }
}