package com.finerioconnect.pfm.example.ui.movements

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.finerioconnect.pfm.example.databinding.FragmentAnalysisDetailBinding
import com.finerioconnect.sdk.models.FCAnalysisCategory

const val ANALYSIS_DETAIL_KEY = "analysisDetailKey"

class AnalysisDetailFragment : Fragment() {
    private lateinit var mBinding: FragmentAnalysisDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentAnalysisDetailBinding.inflate(inflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fcAnalysisCategory = arguments?.getParcelable<FCAnalysisCategory>(ANALYSIS_DETAIL_KEY)
        setup(fcAnalysisCategory)
    }

    private fun setup(fcAnalysisCategory: FCAnalysisCategory?) {
        if (fcAnalysisCategory == null) {
            return
        }
        mBinding.fcAnalysisDetailView.setAnalysis(fcAnalysisCategory)
    }
}