package com.example.foodapp.ui.Home.fragments.menu

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.data.models.MenuPreviewItem
import com.example.foodapp.data.models.OfferItem
import com.example.foodapp.databinding.FragmentFoodPreviewBinding
import com.example.foodapp.databinding.FragmentMenuBinding
import com.example.foodapp.databinding.FragmentMenuPreviewBinding
import com.example.foodapp.ui.Home.fragments.offers.OffersAdapter


class FoodPreviewFragment : Fragment(R.layout.fragment_food_preview) {
    lateinit var binding: FragmentFoodPreviewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodPreviewBinding.inflate(inflater)



        return binding.root
    }

}