package com.finerioconnect.pfm.sdk.modules.budgets.listeners

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.FCBudget

interface UpdateBudgetListener {
    fun budgetUpdated(budget: FCBudget)
    fun error(errors: List<FCError>)
    fun severError(serverError: Throwable)
}