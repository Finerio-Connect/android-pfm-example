package com.finerioconnect.pfm.sdk.modules.categories.listeners

import com.finerioconnect.core.sdk.models.FCCategory
import com.finerioconnect.core.sdk.models.FCError

interface GetCategoriesListener {

    fun categories(categories: List<FCCategory>, nextCursor: Int)

    fun error(errors: List<FCError>)

    fun severError(serverError: Throwable)

}