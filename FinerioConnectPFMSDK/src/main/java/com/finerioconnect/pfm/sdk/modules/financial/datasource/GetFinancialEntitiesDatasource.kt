package com.finerioconnect.pfm.sdk.modules.financial.datasource

import com.finerioconnect.core.sdk.models.responses.FCFinancialEntitiesResponse
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface GetFinancialEntitiesDatasource : BaseDatasource {
    fun success(success: (FCFinancialEntitiesResponse) -> Unit): GetFinancialEntitiesDatasource
    fun getFinancialEntities(userId: Int, cursor: Int?)
}