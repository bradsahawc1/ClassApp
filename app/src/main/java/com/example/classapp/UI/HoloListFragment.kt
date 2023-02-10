package com.example.classapp.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.classapp.HoloAdapter
import com.example.classapp.Holomember
import com.example.classapp.R
import kotlin.random.Random


class HoloListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_holo_list_fragment, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.holomember_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val holomembers = mutableListOf<Holomember>()

        for (i in 0 .. 30) {
            holomembers.add(createHolomember())
        }

        val adapter = HoloAdapter(holomembers)
        recyclerView.adapter = adapter

        return view
    }
    private fun createHolomember() = Holomember(
        image = R.drawable.demopic,
        name = "Tokino Sora",
        subscribers = Random.nextInt(401000, 4270000),
        gen = "Gen 0",
        birthday = "May 15th",
        debut = "September 7, 2017",
        illustrator = "Ordan"
    )
}