package com.example.foodapp.ui.Home.fragments.menu

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentMenuBinding


class MenuFragment : Fragment(R.layout.fragment_menu) {
    lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater)
        setHasOptionsMenu(true)

        binding.apply {
            constraintLayout1.setOnClickListener {
                findNavController().navigate(R.id.action_menuFragment_to_menuPreviewFragment)
            }
            constraintLayout2.setOnClickListener {
                findNavController().navigate(R.id.action_menuFragment_to_menuPreviewFragment)
            }
            constraintLayout3.setOnClickListener {
                findNavController().navigate(R.id.action_menuFragment_to_menuPreviewFragment)
            }
            constraintLayout4.setOnClickListener {
                findNavController().navigate(R.id.action_menuFragment_to_menuPreviewFragment)
            }


        }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}