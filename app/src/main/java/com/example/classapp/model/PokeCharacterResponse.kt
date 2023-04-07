package com.example.classapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
data class PokeCharacterResponse(
    val info: Info,
    @field:Json(name = "results")
    val pokemons: List<Pokemon>,)

data class Info(
    @Json(name = "count")
    val count: Int,
    @Json(name = "next")
    val next: String,
    @Json(name = "prev")
    val prev: Any?,
)
