package com.finerioconnect.pfm.sdk.modules.financial.datasource

import com.finerioconnect.core.sdk.models.FCFinancialEntity
import com.finerioconnect.core.sdk.models.requests.FCUpdateFinancialEntityRequest
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface UpdateFinancialEntityDatasource : BaseDatasource {
    fun success(success: (FCFinancialEntity) -> Unit): UpdateFinancialEntityDatasource
    fun updateFinancialEntity(id: Int, financialEntity: FCUpdateFinancialEntityRequest)
}