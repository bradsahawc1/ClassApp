package com.example.classapp.data

import com.example.classapp.model.PokeCharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApi {
    //pokemon?limit=1285&offset=0

    @GET("/api/v2/pokemon?limit=151")
    suspend fun getCharacters(): Response<PokeCharacterResponse>
}