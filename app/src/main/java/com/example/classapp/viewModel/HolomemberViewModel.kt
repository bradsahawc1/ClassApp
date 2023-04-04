package com.example.classapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.classapp.model.Holomember
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

class HolomemberViewModel @Inject constructor() : ViewModel() {
    private val holomembers = mutableListOf<Holomember>()

    private val images = listOf(
        "https://rickandmortyapi.com/api/character/avatar/291.jpeg",
        "https://rickandmortyapi.com/api/character/avatar/563.jpeg",
        "https://rickandmortyapi.com/api/character/avatar/543.jpeg",
        "https://rickandmortyapi.com/api/character/avatar/553.jpeg",
        "https://rickandmortyapi.com/api/character/avatar/533.jpeg")
    private val names = listOf("Ninomae Ina'nis", "Amelia Watson", "Calliope Mori", "Kiara Takanashi", "Gura Gawr")
    private val illustrators = listOf("Ordan", "Kuromaru9", "Ayamy", "Azumi Akitake", "Haruyuki")

    init {
        createHolomembers()
    }

    fun fillData() = holomembers.toList()

    fun fetchById(id: Int) = holomembers.first {it.id == id}

    private fun createHolomembers() = (0 .. 30).map { id ->
        holomembers.add(
            Holomember(
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
}