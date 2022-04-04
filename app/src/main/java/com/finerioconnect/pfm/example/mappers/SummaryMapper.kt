package com.finerioconnect.pfm.example.mappers

import android.graphics.Color
import com.finerioconnect.core.sdk.models.FCCategory
import com.finerioconnect.core.sdk.models.FCResumeByCategory
import com.finerioconnect.core.sdk.models.FCResumeByMonth
import com.finerioconnect.sdk.models.FCImage
import com.finerioconnect.sdk.models.FCResumeTransaction
import java.text.SimpleDateFormat
import java.util.*


fun getTransactions(resumesByMonth: List<FCResumeByMonth>, isNegativeAmount: Boolean, categories: List<FCCategory>): List<FCResumeTransaction> {
    val transactions = arrayListOf<FCResumeTransaction>()

    resumesByMonth.forEach { resumeByMonth ->
        resumeByMonth.categories.forEach { resumeByCategory ->
            transactions.add(getTransaction(resumeByMonth, resumeByCategory, isNegativeAmount, categories))
        }
    }
    return transactions
}

fun getTransaction(resumeByMonth: FCResumeByMonth, resumeByCategory: FCResumeByCategory, isNegativeAmount: Boolean, categories: List<FCCategory>): FCResumeTransaction {
    val category: FCCategory? = getCategoryById(resumeByCategory.categoryId, categories)
    val imageName = getImageName(category)
    val amount = resumeByCategory.amount
    val image = FCImage(imageName, Color.parseColor(category?.color?:"#ff939598"))
    return FCResumeTransaction(
        imageName,
        SimpleDateFormat("yyyy-MM", Locale("es-MX")).format(Date(resumeByMonth.date)),
        category?.name?:"",
        if(isNegativeAmount) -amount else amount,
        com.finerioconnect.sdk.models.FCCategory(imageName, category?.name?:"", category?.color?:"#FFFFFF", "", image)
    )
}

fun getCategoryById(categoryId: Int, categories: List<FCCategory>): FCCategory? =
    categories.find { it.id == categoryId }

fun getImageName(category: FCCategory?) : String {
    var imageName = "https://cdn-icons.flaticon.com/png/512/1078/premium/1078443.png?token=exp=1646424932~hmac=cf442ef4a3be4abab5a70e1e7132aa71"
    if (category != null) {
        imageName = when (category.name) {
            "Transacciones Bancarias" -> "00000000_0000_0000_0000_000000000047"
            "Finanzas e Impuestos" -> "00000000_0000_0000_0000_00000000000b"
            "Hogar" -> "00000000_0000_0000_0000_000000000001"
            "Entretenimiento" -> "00000000_0000_0000_0000_000000000003"
            "Alimentos" -> "00000000_0000_0000_0000_000000000002"
            "Regalos y Ayuda" -> "00000000_0000_0000_0000_000000000008"
            "Salud y Belleza" -> "00000000_0000_0000_0000_000000000005"
            "Educación y Trabajo" -> "00000000_0000_0000_0000_000000000007"
            "Auto y Transporte" -> "00000000_0000_0000_0000_000000000006"
            "Ingresos" -> "00000000_0000_0000_0000_000000000050"
            else -> "https://cdn-icons.flaticon.com/png/512/1078/premium/1078443.png?token=exp=1646424932~hmac=cf442ef4a3be4abab5a70e1e7132aa71"
        }
    }

    return imageName
}