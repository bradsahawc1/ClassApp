package com.example.classapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.classapp.ui.adapter.PokeAdapter
import com.example.classapp.R
import com.example.classapp.databinding.FragmentPokeListBinding
import com.example.classapp.viewModel.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PokeListFragment : Fragment() {

    private var _binding: FragmentPokeListBinding? = null
    private val binding get() = _binding!!

    private val pokemonViewModel: PokemonViewModel by activityViewModels()
    private val pokeAdapter = PokeAdapter { pokemon, _ ->
        requireActivity().supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                R.id.fragment_container,
                PokeDetailFragment.newInstance(pokemon.id),
            )
            addToBackStack(null)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentPokeListBinding.inflate(inflater, container, false)
        setupObservers()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pokemonRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = pokeAdapter
        }
        pokemonViewModel.fillData()
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            pokemonViewModel.pokemons.collect { event ->
                when (event) {
                    PokemonViewModel.RickAndMortyCharacterEvent.Failure -> {
                        binding.progressBar.isVisible = false
                        binding.pokemonRecyclerView.isVisible = false
                        binding.errorMessage.isVisible = true
                    }
                    PokemonViewModel.RickAndMortyCharacterEvent.Loading -> {
                        binding.progressBar.isVisible = true
                        binding.pokemonRecyclerView.isVisible = false
                        binding.errorMessage.isVisible = false
                    }
                    is PokemonViewModel.RickAndMortyCharacterEvent.Success -> {
                        pokeAdapter.refreshData(event.characters)
                        binding.progressBar.isVisible = false
                        binding.errorMessage.isVisible = false
                        binding.pokemonRecyclerView.isVisible = true
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

/*@AndroidEntryPoint
class PokeListFragment : Fragment() {

    private var _binding: FragmentPokeListBinding? = null
    private val binding get() = _binding!!

    private val pokemonViewModel: PokemonViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokeListBinding.inflate(inflater, container, false)

        binding.pokemonRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        val pokemons = pokemonViewModel.fillData()

        val adapter = PokeAdapter(pokemons) { position ->
            requireActivity().supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(
                    R.id.fragment_container,
                    PokeDetailFragment.newInstance(pokemons[position].id),
                )
                addToBackStack(null)
            }
        }
        binding.pokemonRecyclerView.adapter = adapter

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}*/