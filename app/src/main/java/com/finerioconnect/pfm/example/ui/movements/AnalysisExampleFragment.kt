package com.finerioconnect.pfm.example.ui.movements

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.finerioconnect.core.sdk.models.FCAnalysisByMonth
import com.finerioconnect.core.sdk.models.FCCategory
import com.finerioconnect.core.sdk.models.FCError
import com.finerioconnect.pfm.example.databinding.FragmentAnalysisExampleBinding
import com.finerioconnect.pfm.example.mappers.getFCAnalysis
import com.finerioconnect.pfm.sdk.core.FinerioApi
import com.finerioconnect.pfm.sdk.modules.categories.listeners.GetCategoriesListener
import com.finerioconnect.pfm.sdk.modules.insights.listeners.GetAnalysisListener
import com.finerioconnect.sdk.analysis.ui.listeners.OnFCAnalysisClickListener
import com.finerioconnect.sdk.models.FCAnalysisCategory

class AnalysisExampleFragment : Fragment(), OnFCAnalysisClickListener, GetCategoriesListener, GetAnalysisListener {

    private lateinit var mBinding: FragmentAnalysisExampleBinding

    private val mCategories = arrayListOf<FCCategory>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentAnalysisExampleBinding.inflate(inflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.fcAnalysisView.setListener(this)
        FinerioApi().categories().getAll(371720, null, this)
    }

    override fun didSelectedAnalysis(fcAnalysisCategory: FCAnalysisCategory) {

    }

    override fun categories(categories: List<FCCategory>, nextCursor: Int) {
        mCategories.clear()
        mCategories.addAll(categories)
        FinerioApi().insights().getAnalysis(371720, null, null, null, this)
    }

    override fun analysis(analysis: List<FCAnalysisByMonth>) {
        val fcAnalysis = getFCAnalysis(analysis, mCategories)
        mBinding.fcAnalysisView.setAnalysis(fcAnalysis)
    }

    override fun error(errors: List<FCError>) {
        //Empty method
    }

    override fun severError(serverError: Throwable) {
        //Empty method
    }

}