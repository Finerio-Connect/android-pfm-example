package com.finerioconnect.pfm.example.ui.summary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.responses.FCSummaryResponse
import com.finerioconnect.pfm.example.databinding.FragmentSummaryExampleBinding
import com.finerioconnect.pfm.sdk.core.FinerioApi
import com.finerioconnect.pfm.sdk.modules.insights.listeners.GetSummaryListener
import com.finerioconnect.sdk.models.FCResume
import com.finerioconnect.sdk.shared.enums.TransactionType
import com.finerioconnect.sdk.summary.ui.listeners.OnSummaryViewListener

class SummaryExampleFragment : Fragment(), OnSummaryViewListener {

    private lateinit var mBinding: FragmentSummaryExampleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentSummaryExampleBinding.inflate(inflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.summaryView.apply {
            configure(requireActivity())
            setListener(this@SummaryExampleFragment)
            setTransactions(arrayListOf())
        }
    }

    private fun getSummary(){
        FinerioApi().insights().getSummary(371720, null, null, null, object : GetSummaryListener {
            override fun summary(summary: FCSummaryResponse) {
                //Empty method
            }

            override fun error(errors: List<FCError>) {
                //Empty method
            }

            override fun severError(serverError: Throwable) {
                //Empty method
            }
        })
    }

    override fun didSelectedResume(resume: FCResume, transactionType: TransactionType) {
        //Empty method
    }

    override fun didTapBarChart(month: String) {
        //Empty method
    }

    override fun emptyState(transactionType: TransactionType) {
        //Empty method
    }

}