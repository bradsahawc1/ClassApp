package com.example.classapp.UI.adapter

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
import com.example.classapp.model.Holomember
import com.example.classapp.R
import com.example.classapp.UI.HoloDetailFragment
import com.example.classapp.databinding.HolomemberCardViewBinding


class HoloAdapter(
    private val holomembers: List<Holomember>,
    private val onItemClick: (adapterPosition: Int) -> Unit) :

    RecyclerView.Adapter<HoloAdapter.HolomemberViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolomemberViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HolomemberCardViewBinding.inflate(layoutInflater, parent, false)

        //val view = LayoutInflater.from(parent.context)
        //    .inflate(R.layout.holomember_card_view, parent, false)

        return HolomemberViewHolder(binding) { position ->
            onItemClick(position)
        }
    }

    override fun getItemCount() = holomembers.size

    override fun onBindViewHolder(holder: HolomemberViewHolder, position: Int) {
        val holomember = holomembers[position]
        holder.bind(holomember)
    }

    inner class HolomemberViewHolder(
        private val binding: HolomemberCardViewBinding,
        private val onItemClick: (adapterPosition: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        /*val holoImage: ImageView = itemView.findViewById(R.id.holoimage)
        val holoName: TextView = itemView.findViewById(R.id.holoname)
        val holoSubs: TextView = itemView.findViewById(R.id.holosubs)
        val holoGen: TextView = itemView.findViewById(R.id.hologen)*/

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        fun bind(holomember: Holomember) {
            Glide
                .with(binding.root)
                .load(holomember.image)
                .into(binding.holoimage)

            binding.holoname.text = holomember.name
            binding.holosubs.text = holomember.subscribers.toString() + " subs"
            binding.hologen.text = holomember.gen
        }
    }
}