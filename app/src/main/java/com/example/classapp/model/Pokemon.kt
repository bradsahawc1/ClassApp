package com.example.classapp.model

import com.squareup.moshi.Json

data class Pokemon(
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "image")
    val image: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "ability")
    val ability: List<String>,
    @Json(name = "height")
    val height: Int,
    @Json(name = "weight")
    val weight: Int,
    @Json(name = "type")
    val type: List<String>,
    @Json(name = "desc")
    val desc: String,
) {

}

// data class RickAndMortyCharacter(
//    @Json(name = "created")
//    val created: String,
//    @Json(name = "episode")
//    val episode: List<String>,
//    @Json(name = "gender")
//    val gender: String,
//    @Json(name = "id")
//    val id: Int,
//    @Json(name = "image")
//    val image: String,
//    @Json(name = "location")
//    val location: Location,
//    @Json(name = "name")
//    val name: String,
//    @Json(name = "origin")
//    val origin: Origin,
//    @Json(name = "species")
//    val species: String,
//    @Json(name = "status")
//    val status: String,
//    @Json(name = "type")
//    val type: String,
//    @Json(name = "url")
//    val url: String,
//)