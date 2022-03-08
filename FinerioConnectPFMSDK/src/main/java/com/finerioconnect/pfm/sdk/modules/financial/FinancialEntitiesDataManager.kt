package com.finerioconnect.pfm.sdk.modules.financial

import com.finerioconnect.core.sdk.models.requests.FCCreateFinancialEntityRequest
import com.finerioconnect.core.sdk.models.requests.FCUpdateFinancialEntityRequest
import com.finerioconnect.pfm.sdk.modules.financial.datasource.impl.*
import com.finerioconnect.pfm.sdk.modules.financial.listeners.*
import com.finerioconnect.pfm.sdk.modules.financial.repositories.impl.*

class FinancialEntitiesDataManager {

    fun create(
        financialEntity: FCCreateFinancialEntityRequest,
        listener: CreateFinancialEntityListener
    ) {
        CreateFinancialEntityRepositoryImpl(CreateFinancialEntityDatasourceImpl())
            .setListener(listener)
            .createFinancialEntity(financialEntity)
    }

    fun getAll(cursor: Int?, listener: GetFinancialEntitiesListener) {
        GetFinancialEntitiesRepositoryImpl(GetFinancialEntitiesDatasourceImpl())
            .setListener(listener)
            .getFinancialEntities(cursor)
    }

    fun get(id: Int, listener: GetFinancialEntityListener) {
        GetFinancialEntityRepositoryImpl(GetFinancialEntityDatasourceImpl())
            .setListener(listener)
            .getFinancialEntity(id)
    }

    fun update(
        id: Int,
        financialEntity: FCUpdateFinancialEntityRequest,
        listener: UpdateFinancialEntityListener
    ) {
        UpdateFinancialEntityRepositoryImpl(UpdateFinancialEntityDatasourceImpl())
            .setListener(listener)
            .updateFinancialEntity(id, financialEntity)
    }

    fun delete(id: Int, listener: DeleteFinancialEntityListener) {
        DeleteFinancialEntityRepositoryImpl(DeleteFinancialEntityDatasourceImpl())
            .setListener(listener)
            .deleteFinancialEntity(id)
    }
}