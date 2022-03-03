package com.finerioconnect.pfm.sdk.modules.categories.repositories

import com.finerioconnect.pfm.sdk.modules.categories.listeners.GetCategoriesListener

interface GetCategoriesRepository {

    fun setListener(listener: GetCategoriesListener): GetCategoriesRepository

    /**
     * @param userId The ID of the user.
     * @param cursor The ID of the category where the list starts.
     */
    fun getCategories(userId: Int?, cursor: Int?)

    fun cancelRequest()

}