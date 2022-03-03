package com.finerioconnect.pfm.sdk.base

import com.finerioconnect.core.sdk.models.FCError

interface BaseDatasource {

    fun error(error: (List<FCError>) -> Unit): BaseDatasource

    fun severError(serverError: (Throwable) -> Unit): BaseDatasource

    fun cancel()

}