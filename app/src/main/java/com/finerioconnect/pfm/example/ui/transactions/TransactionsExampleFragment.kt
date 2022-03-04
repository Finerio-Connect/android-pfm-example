package com.finerioconnect.pfm.example.ui.transactions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.finerioconnect.pfm.example.databinding.FragmentTransactionsExampleBinding

class TransactionsExampleFragment: Fragment() {

    private lateinit var mBinding: FragmentTransactionsExampleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentTransactionsExampleBinding.inflate(layoutInflater)
        return mBinding.root
    }

}