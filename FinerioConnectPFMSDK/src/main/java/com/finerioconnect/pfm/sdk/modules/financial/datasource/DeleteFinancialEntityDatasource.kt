package com.finerioconnect.pfm.sdk.modules.financial.datasource

import com.finerioconnect.pfm.sdk.base.BaseDatasource

interface DeleteFinancialEntityDatasource : BaseDatasource {
    fun success(success: (Any) -> Unit): DeleteFinancialEntityDatasource
    fun deleteFinancialEntity(id: Int)
}