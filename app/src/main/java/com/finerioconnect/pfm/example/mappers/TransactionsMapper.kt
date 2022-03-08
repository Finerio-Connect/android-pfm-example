package com.finerioconnect.pfm.example.mappers

import com.finerioconnect.core.sdk.models.FCTransaction
import java.util.*

fun getFCTransaction(
    transactions: List<FCTransaction>,
    categories: List<com.finerioconnect.sdk.models.FCCategory>
): MutableList<com.finerioconnect.sdk.models.FCTransaction> {
    val fcTransactions = mutableListOf<com.finerioconnect.sdk.models.FCTransaction>()
    transactions.forEach { fcTransaction ->
        val date = Date()
        date.time = fcTransaction.date

        var category: com.finerioconnect.sdk.models.FCCategory? = null
        for (fcCategory in categories) {
            category = fcCategory.subCategories?.find {
                it.id == (fcTransaction.categoryId ?: 0).toString()
            }
            if (category != null) break
        }

        fcTransactions.add(
            com.finerioconnect.sdk.models.FCTransaction(
                fcTransaction.id.toString(),
                date,
                fcTransaction.description,
                fcTransaction.description,
                fcTransaction.amount,
                false,
                "",
                false,
                null,
                category
            )
        )
    }
    return fcTransactions
}