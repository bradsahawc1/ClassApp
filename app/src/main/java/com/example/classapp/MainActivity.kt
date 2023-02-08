package com.example.classapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.holomember_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val holomembers = mutableListOf<Holomember>()

        for (i in 0 .. 30) {
            holomembers.add(createHolomember())
        }

        val adapter = HoloAdapter(holomembers)
        recyclerView.adapter = adapter
    }

    private fun createHolomember() = Holomember(
        image = R.drawable.demopic,
        name = "Tokino Sora",
        birthday = "May 15th",
        gen = "Generation 0",
        debut = "September 7, 2017",
        illustrator = "Ordan"
    )
}