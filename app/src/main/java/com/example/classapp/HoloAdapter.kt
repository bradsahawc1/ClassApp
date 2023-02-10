package com.example.classapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class HoloAdapter(private val holomembers: List<Holomember>) : RecyclerView.Adapter<HoloAdapter.HolomemberViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HolomemberViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.holomember_card_view, parent, false)
    )

    override fun getItemCount() = holomembers.size

    override fun onBindViewHolder(holder: HolomemberViewHolder, position: Int) {
        val holomember = holomembers[position]
        holder.holoImage.setImageResource(holomember.image)
        holder.holoName.text = holomember.name
        holder.holoSubs.text = holomember.subscribers.toString()
        holder.holoGen.text = holomember.gen
    }

    class HolomemberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val holoImage: ImageView = itemView.findViewById(R.id.holoimage)
        val holoName: TextView = itemView.findViewById(R.id.holoname)
        val holoSubs: TextView = itemView.findViewById(R.id.holosubs)
        val holoGen: TextView = itemView.findViewById(R.id.hologen)
    }
}