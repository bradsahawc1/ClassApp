package com.example.classapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.classapp.data.model.PokeResponse
import com.example.classapp.data.repository.PokeRepository
import com.example.classapp.model.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetViewModel @Inject constructor(
    private val pokeRepository: PokeRepository,
): ViewModel() {
    private val _pokemons = MutableStateFlow<PokemonCharacterEvent>(PokemonCharacterEvent.Loading)
    val pokemons: StateFlow<PokemonCharacterEvent> = _pokemons

    fun fillData() {
        viewModelScope.launch {
            when (val response = pokeRepository.getCharacters()) {
                PokeResponse.Error -> _pokemons.value = PokemonCharacterEvent.Failure
                is PokeResponse.Success -> _pokemons.value = PokemonCharacterEvent.Success(response.pokemons)
            }
        }
    }

    sealed class PokemonCharacterEvent {
        data class Success (val pokemons: List<Pokemon>) : PokemonCharacterEvent()
        object Failure : PokemonCharacterEvent()
        object Loading : PokemonCharacterEvent()
    }
}