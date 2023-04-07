package com.example.classapp.data.repository

import com.example.classapp.data.PokeApi
import com.example.classapp.data.model.PokeResponse
import javax.inject.Inject

class PokeRepositoryImpl @Inject constructor(
    private val pokeApi: PokeApi,
) : PokeRepository {
    override suspend fun getCharacters(): PokeResponse {
        val result = pokeApi.getCharacters()
        return if (result.isSuccessful) {
            PokeResponse.Success(result.body()?.pokemons ?: emptyList())
        } else {
            PokeResponse.Error
        }
    }
}