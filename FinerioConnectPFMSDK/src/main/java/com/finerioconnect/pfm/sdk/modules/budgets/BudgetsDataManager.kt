package com.finerioconnect.pfm.sdk.modules.budgets

import com.finerioconnect.core.sdk.models.requests.FCCreateBudgetRequest
import com.finerioconnect.core.sdk.models.requests.FCUpdateBudgetRequest
import com.finerioconnect.pfm.sdk.modules.budgets.datasource.impl.*
import com.finerioconnect.pfm.sdk.modules.budgets.listeners.*
import com.finerioconnect.pfm.sdk.modules.budgets.repositories.impl.*

class BudgetsDataManager {

    fun create(budget: FCCreateBudgetRequest, listener: CreateBudgetListener) {
        CreateBudgetRepositoryImpl(CreateBudgetDatasourceImpl())
            .setListener(listener)
            .createBudget(budget)
    }

    fun getAll(userId: Int, cursor: Int?, listener: GetBudgetsListener) {
        GetBudgetsRepositoryImpl(GetBudgetsDatasourceImpl())
            .setListener(listener)
            .getBudgets(userId, cursor)
    }

    fun get(id: Int, listener: GetBudgetListener) {
        GetBudgetRepositoryImpl(GetBudgetDatasourceImpl())
            .setListener(listener)
            .getBudget(id)
    }

    fun update(id: Int, budget: FCUpdateBudgetRequest, listener: UpdateBudgetListener) {
        UpdateBudgetRepositoryImpl(UpdateBudgetDatasourceImpl())
            .setListener(listener)
            .updateBudget(id, budget)
    }

    fun delete(id: Int, listener: DeleteBudgetListener) {
        DeleteBudgetRepositoryImpl(DeleteBudgetDatasourceImpl())
            .setListener(listener)
            .deleteBudget(id)
    }
}