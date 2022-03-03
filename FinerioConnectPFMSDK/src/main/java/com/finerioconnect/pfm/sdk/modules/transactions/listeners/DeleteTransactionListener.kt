package com.finerioconnect.pfm.sdk.modules.transactions.listeners

import com.finerioconnect.core.sdk.models.FCError

interface DeleteTransactionListener {

    fun transactionDeleted()

    fun error(errors: List<FCError>)

    fun severError(serverError: Throwable)

}