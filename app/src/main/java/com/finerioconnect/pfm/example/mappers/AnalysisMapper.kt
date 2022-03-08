package com.finerioconnect.pfm.example.mappers

import com.finerioconnect.core.sdk.models.*
import com.finerioconnect.sdk.analysis.models.FCAnalysis
import com.finerioconnect.sdk.models.FCAnalysisCategory
import com.finerioconnect.sdk.models.FCAnalysisSubCategory
import com.finerioconnect.sdk.models.FCAnalysisTransaction
import java.util.*

fun getFCAnalysis(analysis: List<FCAnalysisByMonth>, categories: List<FCCategory>): MutableList<FCAnalysis> {
    val fcAnalysis = arrayListOf<FCAnalysis>()
    analysis.forEach { fcAnalysisByMonth ->
        val date = Date()
        date.time = fcAnalysisByMonth.date
        fcAnalysis.add(FCAnalysis(date, fcAnalysisByMonth.categories.map {
                fcAnalysisByCategory -> fcAnalysisByCategory.map(fcAnalysisByCategory.categoryId, categories)
        }))
    }
    return fcAnalysis
}

fun FCAnalysisByCategory.map(categoryId: Int, categories: List<FCCategory>): FCAnalysisCategory = FCAnalysisCategory(
    getFCCategoryById(categoryId, categories), amount.toBigDecimal(), subcategories.map { subCategories ->
        subCategories.map(subCategories.categoryId, categories)
    }
)

fun FCAnalysisBySubcategory.map(categoryId: Int, categories: List<FCCategory>): FCAnalysisSubCategory = FCAnalysisSubCategory(
    getFCCategoryById(categoryId, categories), average.toBigDecimal(), quantity, amount.toBigDecimal(), transactions.map { transactions ->
        transactions.map()
    }
)

fun FCAnalysisByTransaction.map(): FCAnalysisTransaction = FCAnalysisTransaction(
    description, average.toBigDecimal(), quantity, amount.toBigDecimal()
)