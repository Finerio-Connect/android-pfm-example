package com.finerioconnect.pfm.example.ui.movements

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.finerioconnect.core.sdk.models.FCAccount
import com.finerioconnect.core.sdk.models.FCCategory
import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.FCTransaction
import com.finerioconnect.pfm.example.databinding.FragmentTransactionsExampleBinding
import com.finerioconnect.pfm.example.mappers.getFCCategories
import com.finerioconnect.pfm.sdk.core.FinerioApi
import com.finerioconnect.pfm.sdk.modules.accounts.listeners.GetAccountsListener
import com.finerioconnect.pfm.sdk.modules.categories.listeners.GetCategoriesListener
import com.finerioconnect.pfm.sdk.modules.transactions.listeners.GetTransactionsListener
import com.finerioconnect.sdk.transaction.core.FinerioTransactionSDK
import com.finerioconnect.sdk.transaction.ui.listeners.OnFCTransactionListListener

class TransactionsExampleFragment : Fragment(), OnFCTransactionListListener, GetCategoriesListener,
    GetAccountsListener, GetTransactionsListener {

    private lateinit var mBinding: FragmentTransactionsExampleBinding

    private val mFcCategories = mutableListOf<com.finerioconnect.sdk.models.FCCategory>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentTransactionsExampleBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.fcTransactionListView.apply {
            setFragmentActivity(requireActivity())
            setListener(this@TransactionsExampleFragment)
            setTransactions(mutableListOf())
        }
        FinerioApi().categories().getAll(371720, null, this)
    }

    override fun didSelectedTransaction(transaction: com.finerioconnect.sdk.models.FCTransaction) {

    }

    override fun categories(categories: List<FCCategory>, nextCursor: Int) {
        mFcCategories.clear()
        mFcCategories.addAll(getFCCategories(categories))
        FinerioTransactionSDK.shared.categories = mFcCategories

        FinerioApi().accounts().getAll(371720, 0, this)
    }

    override fun accounts(accounts: List<FCAccount>, nextCursor: Int) {
        FinerioTransactionSDK.shared.credentials = arrayListOf()

        FinerioApi().transactions().getAll(743438, HashMap(), this)
    }

    override fun transactions(
        transactions: List<FCTransaction>,
        nextCursor: Int
    ) {

    }

    override fun error(errors: List<FCError>) {
        //Empty method
    }

    override fun severError(serverError: Throwable) {
        //Empty method
    }

}