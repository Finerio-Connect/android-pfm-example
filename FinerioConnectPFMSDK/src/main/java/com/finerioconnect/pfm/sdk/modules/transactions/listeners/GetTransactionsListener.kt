package com.finerioconnect.pfm.sdk.modules.transactions.listeners

import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.FCTransaction

interface GetTransactionsListener {

    fun transactions(transactions: List<FCTransaction>, nextCursor: Int)

    fun error(errors: List<FCError>)

    fun severError(serverError: Throwable)

}