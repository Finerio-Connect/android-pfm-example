package com.finerioconnect.pfm.sdk.modules.transactions.repositories

import com.finerioconnect.pfm.sdk.modules.transactions.listeners.GetTransactionsListener

interface GetTransactionsRepository {

    fun setListener(listener: GetTransactionsListener): GetTransactionsRepository

    /**
     * @param accountId The ID of the account where the list starts; Example: accountId=123
     * @param options options can have next params:
     *                - categoryId The ID of the category; Example: categoryId=123
     *                - The description of the transaction. It can be partial; Example: description=UBER
     *                - The type of the transaction (true = charge, false = deposit); Example: charge=true
     *                - The minimum amount of the transaction; Example: minAmount=123.45
     *                - The maximum amount of the transaction; Example: maxAmount=123.45
     *                - The minimum date of the transaction, in UNIX format; Example: dateFrom=1587567125458
     *                - The maxumum date of the transaction, in UNIX format; Example: dateTo=1587567125458
     *                - The ID of the transaction where the list starts; Example: cursor=123
     */
    fun getTransactions(accountId: Int, options: Map<String, String>)

    fun cancelRequest()

}