package com.finerioconnect.pfm.sdk.modules.budgets.listeners

import com.finerioconnect.core.sdk.models.FCError

interface DeleteBudgetListener {
    fun budgetDeleted()
    fun error(errors: List<FCError>)
    fun severError(serverError: Throwable)
}