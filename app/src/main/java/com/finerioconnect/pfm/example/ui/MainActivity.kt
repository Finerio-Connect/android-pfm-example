package com.finerioconnect.pfm.example.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.finerioconnect.pfm.example.R
import com.finerioconnect.pfm.example.databinding.ActivityMainBinding
import com.finerioconnect.pfm.example.ui.accounts.AccountsExampleFragment
import com.finerioconnect.pfm.example.ui.budgets.BudgetsCategoriesExampleFragment
import com.finerioconnect.pfm.example.ui.budgets.BudgetsExampleFragment
import com.finerioconnect.pfm.example.ui.movements.MovementsExampleFragment
import com.finerioconnect.pfm.example.ui.summary.SummaryExampleFragment
import com.finerioconnect.sdk.account.core.FinerioAccountSDK
import com.finerioconnect.sdk.analysis.core.FinerioAnalysisSDK
import com.finerioconnect.sdk.budget.core.FinerioBudgetSDK
import com.finerioconnect.sdk.summary.core.FinerioSummarySDK
import com.finerioconnect.sdk.transaction.core.FinerioTransactionSDK
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var mBinding: ActivityMainBinding

    private val mSummaryExampleFragment = SummaryExampleFragment()
    private val mMovementsExampleFragment = MovementsExampleFragment()
    private val mAccountsExampleFragment = AccountsExampleFragment()
    private val mBudgetsExampleFragment = BudgetsCategoriesExampleFragment()

    private var menuItemId: Int = R.id.summaryMenu

    private var mLastFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setSupportActionBar(mBinding.toolbar)

        FinerioSummarySDK.shared.configure(this)
        FinerioAccountSDK.shared.configure(this)
        FinerioTransactionSDK.shared.configure(this)
        FinerioAnalysisSDK.shared.configure(this)
        FinerioBudgetSDK.shared.configure(this)

        mBinding.bottomNavigation.setOnItemSelectedListener(this)
        transition(mSummaryExampleFragment)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean = when (val id = item.itemId) {
        R.id.summaryMenu -> {
            move(id) { transition(mSummaryExampleFragment) }
        }
        R.id.accountsMenu -> {
            move(id) { transition(mAccountsExampleFragment) }
        }
        R.id.movementsMenu -> {
            move(id) { transition(mMovementsExampleFragment) }
        }
        else -> false
    }

    private fun move(itemIdSelected: Int, move: () -> Unit): Boolean {
        return if (itemIdSelected != menuItemId) {
            menuItemId = itemIdSelected
            move.invoke()
            true
        } else {
            false
        }
    }

    private fun transition(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        if (mLastFragment != null) {
            fragmentTransaction.remove(mLastFragment!!)
        }
        fragmentTransaction.replace(R.id.fragmentContainer, fragment).commitAllowingStateLoss()
        mLastFragment = fragment
    }

}