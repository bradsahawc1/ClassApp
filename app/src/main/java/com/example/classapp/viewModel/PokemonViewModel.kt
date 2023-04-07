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
class PokemonViewModel @Inject constructor(
    private val pokeRepository: PokeRepository,
) : ViewModel() {

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
        data class Success(val pokemons: List<Pokemon>) : PokemonCharacterEvent()
        object Failure : PokemonCharacterEvent()
        object Loading : PokemonCharacterEvent()
    }
}

/*class PokemonViewModel @Inject constructor() : ViewModel() {
    private val pokemons = mutableListOf<Pokemon>()

    private val images = listOf(
        "https://rickandmortyapi.com/api/character/avatar/291.jpeg",
        "https://rickandmortyapi.com/api/character/avatar/563.jpeg",
        "https://rickandmortyapi.com/api/character/avatar/543.jpeg",
        "https://rickandmortyapi.com/api/character/avatar/553.jpeg",
        "https://rickandmortyapi.com/api/character/avatar/533.jpeg")
    private val names = listOf("Ninomae Ina'nis", "Amelia Watson", "Calliope Mori", "Kiara Takanashi", "Gura Gawr")
    private val illustrators = listOf("Ordan", "Kuromaru9", "Ayamy", "Azumi Akitake", "Haruyuki")

    init {
        createPokemembers()
    }

    fun fillData() = pokemons.toList()

    fun fetchById(id: Int) = pokemons.first {it.id == id}

    private fun createPokemembers() = (0 .. 30).map { id ->
        pokemons.add(
            Pokemon(
                id = id,
                image = images.random(),
                name = names.random(),
                subscribers = Random.nextInt(100000, 1000000),
                gen = "HoloMyth",
                birthday = "May 15th",
                debut = "September 7, 2017",
                illustrator = illustrators.random(),
                status = "active",
                description = "Beyond borders, beyond generations, Loved 2D entertainment. We at COVER Starting with \"HoloLive Production\" Content unique to Japan, We are sending out to the world. Lets make. Culture that the world loves. A stage where unique creators can gather and demonstrate their power of expression. A new experience with cutting-edge technology and uncompromising quality. Beyond borders, beyond generations, Create beloved 2D entertainment. However, for that reason, we will continue to take on the challenge. Beyond borders, beyond generations, Loved 2D entertainment. We at COVER Starting with \"HoloLive Production\" Content unique to Japan, We are sending out to the world. Lets make. Culture that the world loves. A stage where unique creators can gather and demonstrate their power of expression. A new experience with cutting-edge technology and uncompromising quality. Beyond borders, beyond generations, Create beloved 2D entertainment. However, for that reason, we will continue to take on the challenge."
            ),
        )
    }
}*/