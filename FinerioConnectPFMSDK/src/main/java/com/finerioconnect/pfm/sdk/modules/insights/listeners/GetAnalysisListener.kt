package com.finerioconnect.pfm.sdk.modules.insights.listeners

import com.finerioconnect.core.sdk.models.FCAnalysisByMonth
import com.finerioconnect.core.sdk.models.FCError

interface GetAnalysisListener {

    fun analysis(analysis: List<FCAnalysisByMonth>)

    fun error(errors: List<FCError>)

    fun severError(serverError: Throwable)

}