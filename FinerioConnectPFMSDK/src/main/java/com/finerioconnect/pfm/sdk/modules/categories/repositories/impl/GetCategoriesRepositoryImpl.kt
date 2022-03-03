package com.finerioconnect.pfm.sdk.modules.categories.repositories.impl

import com.finerioconnect.pfm.sdk.modules.categories.datasources.GetCategoriesDatasource
import com.finerioconnect.pfm.sdk.modules.categories.listeners.GetCategoriesListener
import com.finerioconnect.pfm.sdk.modules.categories.repositories.GetCategoriesRepository

class GetCategoriesRepositoryImpl(
    private val getCategoriesDatasource: GetCategoriesDatasource
) : GetCategoriesRepository {

    private var listener: GetCategoriesListener? = null

    override fun setListener(listener: GetCategoriesListener) = apply {
        this.listener = listener
    }

    override fun getCategories(userId: Int?, cursor: Int?) {
        getCategoriesDatasource
            .success {
                listener?.categories(it.data ?: arrayListOf(), it.nextCursor ?: 0)
            }
            .error {
                listener?.error(it)
            }
            .severError {
                listener?.severError(it)
            }
        getCategoriesDatasource.getCategories(userId, cursor)
    }

    override fun cancelRequest() {
        getCategoriesDatasource.cancel()
    }

}