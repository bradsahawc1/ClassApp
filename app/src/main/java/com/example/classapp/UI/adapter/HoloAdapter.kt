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
    private val onItemClick: (adapterPosition: Int) -> Unit,
) :
    RecyclerView.Adapter<HoloAdapter.HolomemberViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolomemberViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HolomemberCardViewBinding.inflate(layoutInflater, parent, false)

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
        private val onItemClick: (adapterPosition: Int) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        fun bind(holomember: Holomember) {
            Glide
                .with(binding.root)
                .load(holomember.image)
                .error(R.drawable.demopic)
                .into(binding.holoimage)

            binding.holoname.text = holomember.name
            binding.holosubs.text = holomember.subscribers.toString()
            binding.hologen.text = holomember.gen
        }
    }
}

            /*val holomember = holomembers[position]

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
}*/