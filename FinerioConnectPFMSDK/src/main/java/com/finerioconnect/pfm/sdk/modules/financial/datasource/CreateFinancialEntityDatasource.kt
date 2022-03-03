package com.finerioconnect.pfm.sdk.modules.financial.datasource

import com.finerioconnect.core.sdk.models.FCFinancialEntity
import com.finerioconnect.core.sdk.models.requests.FCCreateFinancialEntityRequest
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface CreateFinancialEntityDatasource : BaseDatasource {
    fun success(success: (FCFinancialEntity) -> Unit): CreateFinancialEntityDatasource
    fun createFinancialEntity(budget: FCCreateFinancialEntityRequest)
}