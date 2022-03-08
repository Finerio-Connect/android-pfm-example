package com.finerioconnect.pfm.example.ui.movements

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.finerioconnect.pfm.example.databinding.FragmentMovementsExampleBinding
import com.finerioconnect.pfm.example.ui.movements.adapters.MovementsPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MovementsExampleFragment: Fragment() {

    private lateinit var mBinding: FragmentMovementsExampleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentMovementsExampleBinding.inflate(inflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = with(mBinding) {
        viewPager.adapter = MovementsPagerAdapter(requireActivity())
        val tabs: TabLayout = movementsTabs
        tabs.addTab(tabs.newTab())
        tabs.addTab(tabs.newTab())
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Movements"
                else -> "Analysis"
            }
        }.attach()
    }

}