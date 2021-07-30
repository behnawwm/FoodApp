package com.example.foodapp.ui.Home.fragments.menu

import android.os.Bundle
import android.view.*
import androidx.activity.OnBackPressedCallback
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
            btnChevronAppetizers.setOnClickListener {
                findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToMenuPreviewFragment(tvTitleAppetizers.text.toString()))
            }
            btnChevronDesserts.setOnClickListener {
                findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToMenuPreviewFragment(tvTitleDesserts.text.toString()))
            }
            btnChevronFood.setOnClickListener {
                findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToMenuPreviewFragment(tvTitleFoods.text.toString()))
            }
            btnChevronBeverages.setOnClickListener {
                findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToMenuPreviewFragment(tvTitleBeverages.text.toString()))
            }

            view11.setOnClickListener {
                findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToMenuPreviewFragment(tvTitleFoods.text.toString()))
            }
            view21.setOnClickListener {
                findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToMenuPreviewFragment(tvTitleBeverages.text.toString()))
            }
            view31.setOnClickListener {
                findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToMenuPreviewFragment(tvTitleDesserts.text.toString()))
            }
            view41.setOnClickListener {
                findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToMenuPreviewFragment(tvTitleAppetizers.text.toString()))
            }

        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}