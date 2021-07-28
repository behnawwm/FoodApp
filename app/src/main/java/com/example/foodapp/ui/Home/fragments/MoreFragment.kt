package com.example.foodapp.ui.Home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentMoreBinding
import com.example.foodapp.databinding.FragmentProfileBinding
import com.github.dhaval2404.imagepicker.ImagePicker


class MoreFragment : Fragment(R.layout.fragment_more) {
    lateinit var binding: FragmentMoreBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoreBinding.inflate(inflater)

        binding.apply {



        }

        return binding.root
    }
}