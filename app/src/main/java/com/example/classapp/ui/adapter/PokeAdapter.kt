package com.example.classapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.classapp.model.Pokemon
import com.example.classapp.R
import com.example.classapp.databinding.PokemonCardViewBinding

class PokeAdapter (
    private val onItemClick: (pokemon: Pokemon, adapterPosition: Int) -> Unit,
) : RecyclerView.Adapter<PokeAdapter.PokemonViewHolder>() {
    init {
        setHasStableIds(true)
    }
    private val pokemons = mutableListOf<Pokemon>()

    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(pokemon: List<Pokemon>) {
        pokemons.clear()
        pokemons.addAll(pokemon)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PokemonCardViewBinding.inflate(layoutInflater, parent, false)
        return PokemonViewHolder(binding) { position ->
            onItemClick(pokemons[position], position)
        }
    }

    override fun getItemCount() = pokemons.size

    override fun getItemId(position: Int) = position.toLong()

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val character = pokemons[position]
        holder.bind(character)
    }

    inner class PokemonViewHolder(
        private val binding: PokemonCardViewBinding,
        private val onItemClick: (adapterPosition: Int) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        fun bind(pokemon: Pokemon) {
            Glide
                .with(binding.root)
                .load(pokemon.image)
                .error(R.drawable.demopic)
                .into(binding.pokeimage)

            binding.pokename.text = pokemon.name
            binding.pokesubs.text = pokemon.height.toString()
        }
    }
}


/*class PokeAdapter(
    private val pokemons: List<Pokemon>,
    private val onItemClick: (adapterPosition: Int) -> Unit,
) :
    RecyclerView.Adapter<PokeAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PokemonCardViewBinding.inflate(layoutInflater, parent, false)

        return PokemonViewHolder(binding) { position ->
            onItemClick(position)
        }
    }

    override fun getItemCount() = pokemons.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
    val pokemon = pokemons[position]
    holder.bind(pokemon)
    }

    inner class PokemonViewHolder(
        private val binding: PokemonCardViewBinding,
        private val onItemClick: (adapterPosition: Int) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        fun bind(pokemon: Pokemon) {
            Glide
                .with(binding.root)
                .load(pokemon.image)
                .error(R.drawable.demopic)
                .into(binding.pokeimage)

            binding.pokename.text = pokemon.name
            binding.pokesubs.text = pokemon.subscribers.toString()
            binding.pokegen.text = pokemon.gen
        }
    }
}*/