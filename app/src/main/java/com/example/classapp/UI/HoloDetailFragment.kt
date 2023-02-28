package com.example.classapp.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.classapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HoloDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_holo_detail, container, false)

        if (arguments != null) {
            val image = requireArguments().getString("image")
            val name = requireArguments().getString("name")
            val subscribers = requireArguments().getInt("subs")
            val gen = requireArguments().getString("gen")
            val birthday = requireArguments().getString("birthday")
            val debut = requireArguments().getString("debut")
            val illustrator = requireArguments().getString("illustrator")
            val status = requireArguments().getString("status")
            val description: String? = requireArguments().getString("description")

            Glide
                .with(view.context)
                .load(image)
                .into(view.findViewById<ImageView>(R.id.holodetailimage))

            view.findViewById<TextView>(R.id.holodetailname).text = name
            view.findViewById<TextView>(R.id.holodetaildescription).text = description
            view.findViewById<TextView>(R.id.holodetailsubs).text = subscribers.toString()
            view.findViewById<TextView>(R.id.holodetailgen).text = gen
            view.findViewById<TextView>(R.id.holodetailbirthday).text = birthday
            view.findViewById<TextView>(R.id.holodetaildebut).text = debut
            view.findViewById<TextView>(R.id.holodetailillustrator).text = illustrator
            view.findViewById<TextView>(R.id.holodetailstatus).text = status
        }

        return view
    }
}