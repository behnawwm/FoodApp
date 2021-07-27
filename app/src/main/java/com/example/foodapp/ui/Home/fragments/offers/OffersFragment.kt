package com.example.foodapp.ui.Home.fragments.offers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.data.models.OfferItem
import com.example.foodapp.databinding.FragmentOffersBinding


class OffersFragment : Fragment(R.layout.fragment_offers), OffersAdapter.OnItemPressListener {
    lateinit var binding: FragmentOffersBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOffersBinding.inflate(inflater)

        val offersAdapter = OffersAdapter(this).apply {
            submitList(provideTestDataSet())
        }
        binding.apply {
            rvOffers.setHasFixedSize(true)
            rvOffers.adapter = offersAdapter
            rvOffers.addItemDecoration(initRecyclerDivider())

            btnCheckOffers.setOnClickListener {
                offersAdapter.submitList(
                    provideTestDataSet()
                )
                binding.rvOffers.adapter = offersAdapter
            }
        }


        return binding.root
    }

    private fun provideTestDataSet(): MutableList<OfferItem>? {
        return mutableListOf(
            OfferItem(0, "Pizza", 4.8, 123, "Desserts", "Paris"),
            OfferItem(1, "Hamburger", 3.5, 231, "Fast Food", "London"),
            OfferItem(2, "Hotdog", 2.1, 3, "Cafe", "Paris"),
            OfferItem(3, "Salad", 4.9, 41, "Cafe", "Paris"),
            OfferItem(4, "Beverages", 3.9, 2309, "Cafe", "Paris"),
        )
    }

    private fun initRecyclerDivider(): RecyclerView.ItemDecoration {
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
        return divider
    }

    override fun OnItemClick(item: OfferItem) {
        Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show()
        //todo
    }
}