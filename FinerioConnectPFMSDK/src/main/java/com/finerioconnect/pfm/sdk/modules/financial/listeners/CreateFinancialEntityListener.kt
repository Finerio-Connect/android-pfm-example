package com.finerioconnect.pfm.sdk.modules.financial.listeners

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.FCFinancialEntity

interface CreateFinancialEntityListener {
    fun financialEntityCreated(financialEntity: FCFinancialEntity)
    fun error(errors: List<FCError>)
    fun severError(serverError: Throwable)
}