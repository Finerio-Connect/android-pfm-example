package com.finerioconnect.pfm.sdk.modules.financial.datasource

import com.finerioconnect.core.sdk.models.FCFinancialEntity
import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface GetFinancialEntityDatasource : BaseDatasource {
    fun success(success: (FCFinancialEntity) -> Unit): GetFinancialEntityDatasource
    fun getFinancialEntity(id: Int)
}