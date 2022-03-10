package com.finerioconnect.pfm.example.ui.movements

import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentActivity
import com.finerioconnect.pfm.example.R
import com.finerioconnect.pfm.example.databinding.AlertTransactionDetailBinding
import com.finerioconnect.sdk.models.FCTransaction
import com.finerioconnect.sdk.transaction.ui.listeners.OnFCTransactionDetailListener
import java.util.*

class TransactionDetailAlert(
    private val activity: FragmentActivity, private val listener: CreateUpdateTransaction
) : OnFCTransactionDetailListener {

    private var alertDialog: AlertDialog? = null

    fun show(transaction: FCTransaction? = null, isUpdate: Boolean = false) {
        val alert = AlertDialog.Builder(activity)
        val view = LayoutInflater.from(activity).inflate(R.layout.alert_transaction_detail, null)
        val binding: AlertTransactionDetailBinding = AlertTransactionDetailBinding.bind(view)

        binding.fcTransactionDetailView.apply {
            setFragmentActivity(activity)
            setListener(this@TransactionDetailAlert)
            transaction?.let { setTransaction(it) }
        }

        alert.apply {
            setTitle("Transaction detail")
            setView(view)
            if (isUpdate) {
                setPositiveButton("Update") { _, _ ->
                    listener.update(binding.fcTransactionDetailView.getTransaction())
                }
            }
            setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
        }
        alertDialog = alert.create()
        alertDialog?.show()
    }

    override fun didAccountChanged(accountId: String) {
        // Empty method
    }

    override fun didCategoryChanged(categoryId: String) {
        // Empty method
    }

    override fun didCreateTransaction(transaction: FCTransaction) {
        alertDialog?.dismiss()
        listener.create(transaction)
    }

    override fun didDateChanged(date: Date) {
        // Empty method
    }

    override fun didDescriptionChanged(description: String, isIncome: Boolean) {
        // Empty method
    }

    override fun didTransactionTypeChanged(isIncome: Boolean) {
        // Empty method
    }

    interface CreateUpdateTransaction {

        fun create(fcTransaction: FCTransaction)

        fun update(fcTransaction: FCTransaction)

    }

}