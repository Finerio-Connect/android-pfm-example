package com.finerioconnect.pfm.example.mappers

import com.finerioconnect.core.sdk.models.FCTransaction
import java.util.*

fun getFCTransactions(
    transactions: List<FCTransaction>,
    categories: List<com.finerioconnect.sdk.models.FCCategory>
): MutableList<com.finerioconnect.sdk.models.FCTransaction> {
    val fcTransactions = mutableListOf<com.finerioconnect.sdk.models.FCTransaction>()
    transactions.forEach { transaction ->
        fcTransactions.add(getFCTransaction(transaction, categories))
    }
    return fcTransactions
}

fun getFCTransaction(
    transaction: FCTransaction,
    categories: List<com.finerioconnect.sdk.models.FCCategory>
): com.finerioconnect.sdk.models.FCTransaction {

    val date = Date()
    date.time = transaction.date

    var category: com.finerioconnect.sdk.models.FCCategory? = null
    for (fcCategory in categories) {
        category = fcCategory.subCategories?.find {
            it.id == (transaction.categoryId ?: 0).toString()
        }
        if (category != null) break
    }

    return com.finerioconnect.sdk.models.FCTransaction(
        transaction.id.toString(),
        date,
        transaction.description,
        transaction.description,
        transaction.amount,
        false,
        "",
        false,
        null,
        category
    )
}