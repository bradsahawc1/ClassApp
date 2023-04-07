package com.example.classapp.data.repository

import com.example.classapp.data.model.PokeResponse

interface PokeRepository {
    suspend fun getCharacters(): PokeResponse
}