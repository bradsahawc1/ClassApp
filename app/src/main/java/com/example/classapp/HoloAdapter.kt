package com.example.classapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.classapp.UI.HoloDetailFragment


class HoloAdapter(private val holomembers: List<Holomember>) :
    RecyclerView.Adapter<HoloAdapter.HolomemberViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolomemberViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.holomember_card_view, parent, false)
        return HolomemberViewHolder(view) { position ->
            val holomember = holomembers[position]

            val bundle = bundleOf(
                "image" to holomember.image,
                "name" to holomember.name,
                "subs" to holomember.subscribers,
                "gen" to holomember.gen,
                "birthday" to holomember.birthday,
                "debut" to holomember.debut,
                "illustrator" to holomember.illustrator,
                "status" to holomember.status,
                "description" to holomember.description
            )

            val detailFragment = HoloDetailFragment()
            detailFragment.arguments = bundle

            val activity = view.context as AppCompatActivity

            activity.supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container, detailFragment)
                addToBackStack(null)
            }
        }
    }

    override fun getItemCount() = holomembers.size

    override fun onBindViewHolder(holder: HolomemberViewHolder, position: Int) {
        val holomember = holomembers[position]
        Glide
            .with(holder.itemView.context)
            .load(holomember.image)
            .into(holder.holoImage)

        holder.holoName.text = holomember.name
        holder.holoSubs.text = holomember.subscribers.toString() + " subs"
        holder.holoGen.text = holomember.gen
    }

    inner class HolomemberViewHolder(
        itemView: View,
        private val onItemClick: (adapterPosition: Int) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        val holoImage: ImageView = itemView.findViewById(R.id.holoimage)
        val holoName: TextView = itemView.findViewById(R.id.holoname)
        val holoSubs: TextView = itemView.findViewById(R.id.holosubs)
        val holoGen: TextView = itemView.findViewById(R.id.hologen)

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }
    }
}