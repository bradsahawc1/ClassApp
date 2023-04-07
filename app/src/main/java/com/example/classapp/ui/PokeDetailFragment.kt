package com.example.classapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.classapp.databinding.FragmentPokeDetailBinding
import com.example.classapp.viewModel.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokeDetailFragment : Fragment() {

    private var _binding: FragmentPokeDetailBinding? = null
    private val binding get() = _binding!!

    private val pokemonViewModel: PokemonViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPokeDetailBinding.inflate(inflater, container, false)

        if (arguments != null) {
            val image = requireArguments().getString("image")
            val name = requireArguments().getString("name")
            val id = requireArguments().getInt("subs")
            val ability = requireArguments().getString("gen")
            val type = requireArguments().getString("birthday")
            val weight = requireArguments().getString("weight")
            val height = requireArguments().getString("height")
            val desc: String? = requireArguments().getString("description")

            Glide
                .with(requireContext())
                .load(image)
                .into(binding.pokedetailimage)

            binding.pokedetailname.text = name
            binding.pokedetaildesc.text = desc
            binding.pokedetailid.text = id.toString()
            binding.pokedetailability.text = ability
            binding.pokedetailtype.text = type
            binding.pokedetailmeasurements.text = weight.toString() + "" + height.toString()
        }

        return binding.root
    }

    companion object {
        private const val BUNDLE_ID = "pokemon_id"

        fun newInstance(id: Int) = PokeDetailFragment().apply {
            arguments = bundleOf(BUNDLE_ID to id)
        }
    }
}