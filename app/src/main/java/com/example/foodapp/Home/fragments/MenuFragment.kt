package com.example.foodapp.Home.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.foodapp.R


class MenuFragment : Fragment(R.layout.fragment_menu) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        setHasOptionsMenu(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}