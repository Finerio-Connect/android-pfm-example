package com.finerioconnect.pfm.sdk.modules.transactions.listeners

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.FCTransaction

interface UpdateTransactionListener {

    fun transactionUpdated(transaction: FCTransaction)

    fun error(errors: List<FCError>)

    fun severError(serverError: Throwable)

}