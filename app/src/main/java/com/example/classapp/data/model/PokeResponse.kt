package com.example.classapp.data.model

import com.example.classapp.model.Pokemon

sealed class PokeResponse {
    data class Success(val pokemons: List<Pokemon>) : PokeResponse()
    object Error : PokeResponse()
}
