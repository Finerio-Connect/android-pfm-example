package com.finerioconnect.pfm.sdk.modules.financial.listeners

import com.finerioconnect.core.sdk.models.FCError

interface DeleteFinancialEntityListener {
    fun financialEntityDeleted()
    fun error(errors: List<FCError>)
    fun severError(serverError: Throwable)
}