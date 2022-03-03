package com.finerioconnect.pfm.sdk.modules.categories.listeners

import com.finerioconnect.core.sdk.models.FCCategory
import com.finerioconnect.core.sdk.models.FCError

interface GetCategoryListener {

    fun category(category: FCCategory)

    fun error(errors: List<FCError>)

    fun severError(serverError: Throwable)

}