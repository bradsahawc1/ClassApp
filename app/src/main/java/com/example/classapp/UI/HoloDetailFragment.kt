package com.example.classapp.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.classapp.R
import com.example.classapp.databinding.FragmentHoloDetailBinding
import com.example.classapp.viewModel.HolomemberViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HoloDetailFragment : Fragment() {

    private var _binding: FragmentHoloDetailBinding? = null
    private val binding get() = _binding!!

    private val holomemberViewModel: HolomemberViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHoloDetailBinding.inflate(inflater, container, false)

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
                .with(requireContext())
                .load(image)
                .into(binding.holodetailimage)

            binding.holodetailname.text = name
            binding.holodetaildescription.text = description
            binding.holodetailsubs.text = subscribers.toString()
            binding.holodetailgen.text = gen
            binding.holodetailbirthday.text = birthday
            binding.holodetaildebut.text = debut
            binding.holodetailillustrator.text = illustrator
            binding.holodetailstatus.text = status
        }

        return binding.root
    }

    companion object {
        private const val BUNDLE_ID = "holomember_id"

        fun newInstance(id: Int) = HoloDetailFragment().apply {
            arguments = bundleOf(BUNDLE_ID to id)
        }
    }
}