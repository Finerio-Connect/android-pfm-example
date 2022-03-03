package com.finerioconnect.pfm.sdk.modules.categories.listeners

import com.finerioconnect.core.sdk.models.FCError

interface DeleteCategoryListener {

    fun categoryDeleted()

    fun error(errors: List<FCError>)

    fun severError(serverError: Throwable)

}