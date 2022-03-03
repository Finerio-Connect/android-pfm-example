package com.finerioconnect.pfm.sdk.modules.insights.listeners

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.responses.FCSummaryResponse

interface GetSummaryListener {
    fun summary(summary: FCSummaryResponse)
    fun error(errors: List<FCError>)
    fun severError(serverError: Throwable)
}