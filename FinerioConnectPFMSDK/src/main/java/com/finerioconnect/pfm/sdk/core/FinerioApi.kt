package com.finerioconnect.pfm.sdk.core

import com.finerioconnect.pfm.sdk.modules.accounts.AccountsDataManager
import com.finerioconnect.pfm.sdk.modules.budgets.BudgetsDataManager
import com.finerioconnect.pfm.sdk.modules.categories.CategoriesDataManager
import com.finerioconnect.pfm.sdk.modules.financial.FinancialEntitiesDataManager
import com.finerioconnect.pfm.sdk.modules.insights.InsightsDataManager
import com.finerioconnect.pfm.sdk.modules.transactions.TransactionsDataManager
import com.finerioconnect.pfm.sdk.modules.users.UsersDataManager

class FinerioApi {

    private val transactionsDataManager: TransactionsDataManager by lazy { TransactionsDataManager() }
    private val accountsDataManager: AccountsDataManager by lazy { AccountsDataManager() }
    private val budgetsDataManager: BudgetsDataManager by lazy { BudgetsDataManager() }
    private val categoriesDataManager: CategoriesDataManager by lazy { CategoriesDataManager() }
    private val insightsDataManager: InsightsDataManager by lazy { InsightsDataManager() }
    private val financialEntitiesDataManager: FinancialEntitiesDataManager by lazy { FinancialEntitiesDataManager() }
    private val usersDataManager: UsersDataManager by lazy { UsersDataManager() }

    fun transactions(): TransactionsDataManager = transactionsDataManager

    fun accounts(): AccountsDataManager = accountsDataManager

    fun budgets(): BudgetsDataManager = budgetsDataManager

    fun categories(): CategoriesDataManager = categoriesDataManager

    fun insights(): InsightsDataManager = insightsDataManager

    fun financial(): FinancialEntitiesDataManager = financialEntitiesDataManager

    fun users(): UsersDataManager = usersDataManager
}