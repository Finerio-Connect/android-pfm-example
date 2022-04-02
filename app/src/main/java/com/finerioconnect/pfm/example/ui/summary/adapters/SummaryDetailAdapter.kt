package com.finerioconnect.pfm.example.ui.summary.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.finerioconnect.pfm.example.R
import com.finerioconnect.pfm.example.ui.summary.adapters.holders.SummaryDetailHolder
import com.finerioconnect.sdk.models.FCResumeTransaction

class SummaryDetailAdapter(
    private val items: List<FCResumeTransaction>,
    private val mSummaryColor: String,
) : RecyclerView.Adapter<SummaryDetailHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SummaryDetailHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_summary_detail_group, parent, false)
        return SummaryDetailHolder(view)
    }

    override fun onBindViewHolder(holder: SummaryDetailHolder, position: Int) {
        holder.bind(items[position], mSummaryColor)
    }

    override fun getItemCount(): Int = items.size
}

