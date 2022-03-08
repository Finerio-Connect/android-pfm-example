package com.finerioconnect.pfm.example.ui.movements

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.finerioconnect.core.sdk.models.FCCategory
import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.FCTransaction
import com.finerioconnect.pfm.example.databinding.FragmentTransactionsExampleBinding
import com.finerioconnect.pfm.example.mappers.getFCCategories
import com.finerioconnect.pfm.example.mappers.getFCTransaction
import com.finerioconnect.pfm.sdk.core.FinerioApi
import com.finerioconnect.pfm.sdk.modules.categories.listeners.GetCategoriesListener
import com.finerioconnect.pfm.sdk.modules.transactions.listeners.GetTransactionsListener
import com.finerioconnect.sdk.transaction.core.FinerioTransactionSDK
import com.finerioconnect.sdk.transaction.ui.listeners.OnFCTransactionListListener

class TransactionsExampleFragment : Fragment(), OnFCTransactionListListener, GetCategoriesListener,
    GetTransactionsListener {

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

        }
        FinerioApi().categories().getAll(371720, null, this)
    }

    override fun didSelectedTransaction(transaction: com.finerioconnect.sdk.models.FCTransaction) {

    }

    override fun categories(categories: List<FCCategory>, nextCursor: Int) {
        mFcCategories.clear()
        mFcCategories.addAll(getFCCategories(categories))
        FinerioTransactionSDK.shared.credentials = arrayListOf()
        FinerioTransactionSDK.shared.categories = mFcCategories

        FinerioApi().transactions().getAll(743438, HashMap(), this)
    }

    override fun transactions(transactions: List<FCTransaction>, nextCursor: Int) {
        val fcTransactions = getFCTransaction(transactions, mFcCategories)
        mBinding.fcTransactionListView.setTransactions(fcTransactions)
    }

    override fun error(errors: List<FCError>) {
        //Empty method
    }

    override fun severError(serverError: Throwable) {
        //Empty method
    }

}