package com.example.classapp.data

import com.example.classapp.model.PokeCharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokeApi {
    //pokemon?limit=1285&offset=0
    @GET("/api/v2/pokemon/")
    suspend fun getCharacters(): Response<PokeCharacterResponse>
}