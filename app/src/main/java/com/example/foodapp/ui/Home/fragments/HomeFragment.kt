package com.example.foodapp.ui.Home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentHomeBinding
import com.google.android.material.bottomappbar.BottomAppBar


class HomeFragment : Fragment(R.layout.fragment_home) {
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)

        requireActivity().findViewById<BottomAppBar>(R.id.bottom_appbar).performShow()

        return binding.root
    }
}