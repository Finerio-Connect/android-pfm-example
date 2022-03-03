package com.finerioconnect.pfm.sdk.modules.budgets.listeners

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.responses.FCBudgetsResponse

interface GetBudgetsListener {
    fun budgetsObtained(budgets: FCBudgetsResponse)
    fun error(errors: List<FCError>)
    fun severError(serverError: Throwable)
}