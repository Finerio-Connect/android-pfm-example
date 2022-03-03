package com.finerioconnect.pfm.sdk.modules.financial.listeners

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.FCFinancialEntity

interface UpdateFinancialEntityListener {
    fun financialEntityUpdated(budget: FCFinancialEntity)
    fun error(errors: List<FCError>)
    fun severError(serverError: Throwable)
}