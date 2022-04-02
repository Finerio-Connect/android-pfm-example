package com.finerioconnect.pfm.example.ui.summary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.finerioconnect.core.sdk.models.FCCategory
import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.core.sdk.models.responses.FCSummaryResponse
import com.finerioconnect.pfm.example.databinding.FragmentSummaryExampleBinding
import com.finerioconnect.pfm.example.mappers.getTransactions
import com.finerioconnect.pfm.sdk.core.FinerioApi
import com.finerioconnect.pfm.sdk.modules.categories.listeners.GetCategoriesListener
import com.finerioconnect.pfm.sdk.modules.insights.listeners.GetSummaryListener
import com.finerioconnect.sdk.models.FCResume
import com.finerioconnect.sdk.models.FCResumeTransaction
import com.finerioconnect.sdk.shared.enums.TransactionType
import com.finerioconnect.sdk.summary.ui.listeners.OnSummaryViewListener

class SummaryExampleFragment : Fragment(), OnSummaryViewListener, GetCategoriesListener,
    GetSummaryListener {

    private lateinit var mBinding: FragmentSummaryExampleBinding

    private val mCategories: MutableList<FCCategory> = mutableListOf()

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
        }
        if (mCategories.isEmpty()) {
            FinerioApi().categories().getAll(371720, null, this)
        } else {
            FinerioApi().insights().getSummary(371720, null, null, null, this)
        }
    }

    override fun didSelectedResume(resume: FCResume, transactionType: TransactionType) {
        val bottomFragment = BottomSheetSummaryDetail()
        bottomFragment.setTransactions(resume.transactions, resume.color)
        bottomFragment.show(requireActivity().supportFragmentManager, "BottomSheetSummaryDetail")
    }

    override fun didTapBarChart(month: String) {
        //Empty method
    }

    override fun emptyState(transactionType: TransactionType) {
        //Empty method
    }

    override fun categories(categories: List<FCCategory>, nextCursor: Int) {
        mCategories.addAll(categories)
        FinerioApi().insights().getSummary(371720, 743438, null, null, this)
    }

    override fun summary(summary: FCSummaryResponse) {
        configSummaryView(summary, mCategories)
    }

    private fun configSummaryView(summary: FCSummaryResponse, categories: List<FCCategory>) {
        val list = arrayListOf<FCResumeTransaction>()
        list.addAll(getTransactions(summary.incomes, false, categories))
        list.addAll(getTransactions(summary.expenses, true, categories))
        mBinding.summaryView.setTransactions(list)
    }

    override fun error(errors: List<FCError>) {
        //Empty method
    }

    override fun severError(serverError: Throwable) {
        //Empty method
    }
}
