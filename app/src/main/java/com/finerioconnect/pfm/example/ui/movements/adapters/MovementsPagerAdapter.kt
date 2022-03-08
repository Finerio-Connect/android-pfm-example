package com.finerioconnect.pfm.example.ui.movements.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.finerioconnect.pfm.example.ui.movements.AnalysisExampleFragment
import com.finerioconnect.pfm.example.ui.movements.TransactionsExampleFragment

class MovementsPagerAdapter(
    fragment: FragmentActivity
) : FragmentStateAdapter(fragment) {

    private val fragments: List<Fragment> = arrayListOf(TransactionsExampleFragment(), AnalysisExampleFragment())

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

}