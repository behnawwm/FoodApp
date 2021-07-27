package com.example.foodapp.Home.fragments.offers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentOffersBinding


class OffersFragment : Fragment(R.layout.fragment_offers), OffersAdapter.OnItemPressListener {
    lateinit var binding: FragmentOffersBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOffersBinding.inflate(inflater)

        val offersAdapter = OffersAdapter(this)
        binding.apply {
            rvOffers.setHasFixedSize(true)
            rvOffers.adapter = offersAdapter
            //
            val divider = DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )

            divider.setDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.shape_divider
                )!!
            )

            rvOffers.addItemDecoration(divider)
            //
        }

        binding.btnCheckOffers.setOnClickListener {
            offersAdapter.submitList(
                mutableListOf(
                    OfferItem(0, "Pizza", 4.8, 123, "Desserts", "Paris"),
                    OfferItem(1, "Hamburger", 3.5, 231, "Fast Food", "London"),
                    OfferItem(2, "Hotdog", 2.1, 3, "Cafe", "Paris"),
                    OfferItem(3, "Salad", 4.9, 41, "Cafe", "Paris"),
                    OfferItem(4, "Beverages", 3.9, 2309, "Cafe", "Paris"),
                )
            )
            binding.rvOffers.adapter = offersAdapter
        }

        return binding.root
    }

    override fun OnItemClick(item: OfferItem) {
        Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show()
        //todo
    }
}