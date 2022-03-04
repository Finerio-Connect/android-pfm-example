package com.finerioconnect.pfm.example.ui.accounts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.finerioconnect.pfm.example.databinding.FragmentAccountsExampleBinding

class AccountsExampleFragment: Fragment() {

    private lateinit var mBinding: FragmentAccountsExampleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentAccountsExampleBinding.inflate(layoutInflater)
        return mBinding.root
    }

}