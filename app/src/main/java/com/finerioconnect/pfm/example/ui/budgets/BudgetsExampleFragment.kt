package com.finerioconnect.pfm.example.ui.budgets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.finerioconnect.pfm.example.databinding.FragmentBudgetsExampleBinding

class BudgetsExampleFragment: Fragment() {

    private lateinit var mBinding: FragmentBudgetsExampleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentBudgetsExampleBinding.inflate(layoutInflater)
        return mBinding.root
    }

}