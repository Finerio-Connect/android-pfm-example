package com.finerioconnect.pfm.example.ui.summary

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.finerioconnect.pfm.example.databinding.BottomSheetSummaryDetailBinding
import com.finerioconnect.pfm.example.ui.summary.adapters.SummaryDetailAdapter
import com.finerioconnect.sdk.extensions.formatAmount
import com.finerioconnect.sdk.models.FCResumeTransaction
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.math.BigDecimal

class BottomSheetSummaryDetail : BottomSheetDialogFragment() {

    private lateinit var mBinding: BottomSheetSummaryDetailBinding

    private lateinit var mAdapter: SummaryDetailAdapter

    private lateinit var mTransactions: List<FCResumeTransaction>

    private var mSummaryColor: String = "#111111"

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val bottomSheetDialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        bottomSheetDialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        bottomSheetDialog.behavior.skipCollapsed = true
        return bottomSheetDialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = BottomSheetSummaryDetailBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setup()
    }

    fun setTransactions(transactions: List<FCResumeTransaction>, color: String) {
        this.mTransactions = transactions
        this.mSummaryColor = color
    }

    private fun setup() {
        mBinding.fcHeaderView.clickCloseButton {
            dismiss()
        }

        showTransactions()
        setTotalAmount()
    }

    private fun showTransactions() {
        mAdapter = SummaryDetailAdapter(mTransactions, mSummaryColor)

        val layoutManager = LinearLayoutManager(context)
        mBinding.recyclerViewSummary.layoutManager = layoutManager
        mBinding.recyclerViewSummary.adapter = mAdapter
    }

    private fun setTotalAmount() {
        var totalAmount = 0.0
        for (transaction in mTransactions) {
            totalAmount += Math.abs(transaction.amount)
        }

        configAmountStyle(BigDecimal(totalAmount))
    }

    @SuppressLint("SetTextI18n")
    private fun configAmountStyle(amount: BigDecimal?) = with(mBinding.textviewTotalAmount) {
        val totalAmountFormatted = (amount ?: BigDecimal(0.0)).formatAmount()
        text = "Total: " + totalAmountFormatted
    }
}