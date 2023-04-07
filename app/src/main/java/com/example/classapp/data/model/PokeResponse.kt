package com.example.classapp.data.model

import com.example.classapp.model.Pokemon

sealed class PokeResponse {
    data class Success(val characters: List<Pokemon>) : PokeResponse()
    object Error : PokeResponse()
}
