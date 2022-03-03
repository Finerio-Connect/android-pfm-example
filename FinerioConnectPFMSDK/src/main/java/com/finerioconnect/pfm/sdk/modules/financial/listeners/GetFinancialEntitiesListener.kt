package com.finerioconnect.pfm.sdk.modules.financial.listeners

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.responses.FCFinancialEntitiesResponse

interface GetFinancialEntitiesListener {
    fun financialEntitiesObtained(financialEntities: FCFinancialEntitiesResponse)
    fun error(errors: List<FCError>)
    fun severError(serverError: Throwable)
}