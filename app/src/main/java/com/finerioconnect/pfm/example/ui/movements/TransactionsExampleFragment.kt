package com.finerioconnect.pfm.example.ui.movements

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.finerioconnect.core.sdk.models.FCCategory
import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.FCTransaction
import com.finerioconnect.core.sdk.models.requests.FCCreateTransactionRequest
import com.finerioconnect.core.sdk.models.requests.FCUpdateTransactionRequest
import com.finerioconnect.pfm.example.databinding.FragmentTransactionsExampleBinding
import com.finerioconnect.pfm.example.mappers.getFCCategories
import com.finerioconnect.pfm.example.mappers.getFCTransaction
import com.finerioconnect.pfm.example.mappers.getFCTransactions
import com.finerioconnect.pfm.sdk.core.FinerioApi
import com.finerioconnect.pfm.sdk.modules.categories.listeners.GetCategoriesListener
import com.finerioconnect.pfm.sdk.modules.transactions.listeners.CreateTransactionListener
import com.finerioconnect.pfm.sdk.modules.transactions.listeners.GetTransactionsListener
import com.finerioconnect.pfm.sdk.modules.transactions.listeners.UpdateTransactionListener
import com.finerioconnect.sdk.transaction.core.FinerioTransactionSDK
import com.finerioconnect.sdk.transaction.ui.listeners.OnFCTransactionListListener
import java.lang.Exception
import java.lang.StringBuilder
import java.util.*

class TransactionsExampleFragment : Fragment(), OnFCTransactionListListener, GetCategoriesListener,
    GetTransactionsListener, TransactionDetailAlert.CreateUpdateTransaction,
    CreateTransactionListener, UpdateTransactionListener {

    private lateinit var mBinding: FragmentTransactionsExampleBinding

    private val mFcCategories = mutableListOf<com.finerioconnect.sdk.models.FCCategory>()

    private val mTransactions = mutableListOf<FCTransaction>()

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
        mBinding.fabCreateTransaction.setOnClickListener {
            TransactionDetailAlert(requireActivity(), this).show()
        }
        FinerioApi().categories().getAll(371720, null, this)
    }

    override fun didSelectedTransaction(transaction: com.finerioconnect.sdk.models.FCTransaction) {
        TransactionDetailAlert(requireActivity(), this).show(transaction, true)
    }

    override fun categories(categories: List<FCCategory>, nextCursor: Int) {
        mFcCategories.clear()
        mFcCategories.addAll(getFCCategories(categories))
        FinerioTransactionSDK.shared.credentials = arrayListOf()
        FinerioTransactionSDK.shared.categories = mFcCategories

        FinerioApi().transactions().getAll(743438, HashMap(), this)
    }

    override fun transactions(transactions: List<FCTransaction>, nextCursor: Int) {
        mTransactions.clear()
        mTransactions.addAll(transactions)
        val fcTransactions = getFCTransactions(transactions, mFcCategories)
        mBinding.fcTransactionListView.setTransactions(fcTransactions)
    }

    override fun transactionCreated(transaction: FCTransaction) {
        Toast.makeText(requireContext(), "Creada exitosamente!", Toast.LENGTH_SHORT).show()
        FinerioApi().transactions().getAll(743438, HashMap(), this)
    }

    override fun transactionUpdated(transaction: FCTransaction) {
        mBinding.fcTransactionListView.updateTransaction(getFCTransaction(transaction, mFcCategories))
    }

    override fun error(errors: List<FCError>) {
        val error = StringBuilder("")
        errors.forEach { error.append(it.title).append(":").append(it.detail).append("\n") }
        Toast.makeText(requireContext(), "Error: $error", Toast.LENGTH_SHORT).show()
    }

    override fun severError(serverError: Throwable) {
        Toast.makeText(requireContext(), "Error: ${serverError.message}", Toast.LENGTH_SHORT).show()
    }

    override fun create(fcTransaction: com.finerioconnect.sdk.models.FCTransaction) {
        val categoryId: Int? = try {
            fcTransaction.category?.id?.toInt()
        } catch (e: Exception){
            null
        }

        var date = fcTransaction.date?.time ?: Date().time
        date = date / 1000 //remove milliseconds
        val request = FCCreateTransactionRequest(
            accountId = 743438,
            date = date,
            charge = fcTransaction.amount < 0,
            description = fcTransaction.description,
            amount = fcTransaction.amount.toBigDecimal().abs().toDouble(),
            categoryId = categoryId
        )
        FinerioApi().transactions().create(request, this)
    }

    override fun update(fcTransaction: com.finerioconnect.sdk.models.FCTransaction) {
        findTransaction(fcTransaction)?.let {
            val categoryId: Int? = try {
                fcTransaction.category?.id?.toInt()
            } catch (e: Exception){
                null
            }
            val request = FCUpdateTransactionRequest(
                date = fcTransaction.date?.time ?: Date().time,
                charge = fcTransaction.amount < 0,
                description = fcTransaction.description,
                amount = fcTransaction.amount.toBigDecimal().abs().toDouble(),
                categoryId = categoryId
            )
            FinerioApi().transactions().update(it.id, request, this)
        }
    }

    private fun findTransaction(transaction: com.finerioconnect.sdk.models.FCTransaction): FCTransaction? =
        mTransactions.find { it.id.toString() == transaction.id }

}