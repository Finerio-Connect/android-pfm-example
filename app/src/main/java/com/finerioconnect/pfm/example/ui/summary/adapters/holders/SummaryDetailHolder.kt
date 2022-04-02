package com.finerioconnect.pfm.example.ui.summary.adapters.holders

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.finerioconnect.pfm.example.databinding.ItemSummaryDetailGroupBinding
import com.finerioconnect.sdk.extensions.formatAmount
import com.finerioconnect.sdk.models.FCResumeTransaction
import java.math.BigDecimal

class SummaryDetailHolder(
    view: View
) : RecyclerView.ViewHolder(view) {
    private val mBinding = ItemSummaryDetailGroupBinding.bind(view)

    fun bind(transaction: FCResumeTransaction, mSummaryColor: String) = with(mBinding) {
        textViewName.text = transaction.description
        imageViewIcon.setColorFilter(Color.parseColor(mSummaryColor), android.graphics.PorterDuff.Mode.SRC_IN);

        configAmountStyle(textViewAmount, BigDecimal(Math.abs(transaction.amount)))
    }

    private fun configAmountStyle(tvAmount: TextView, amount: BigDecimal?) = with(tvAmount) {
        val totalAmountFormatted = (amount ?: BigDecimal(0.0)).formatAmount()
        text = totalAmountFormatted
    }
}