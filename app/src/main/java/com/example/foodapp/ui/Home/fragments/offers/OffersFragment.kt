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
import com.example.foodapp.Utils.ContextUtils.showWarningToasty
import com.example.foodapp.data.TestDataSet
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
            submitList(TestDataSet.provideOffersTestDataSet())
        }
        binding.apply {
            rvOffers.setHasFixedSize(true)
            rvOffers.adapter = offersAdapter
//            rvOffers.addItemDecoration(initRecyclerDivider())

            btnCheckOffers.setOnClickListener {
                offersAdapter.submitList(
                    TestDataSet.provideOffersTestDataSet()
                )
                binding.rvOffers.adapter = offersAdapter
            }
        }


        return binding.root
    }


    private fun initRecyclerDivider(): RecyclerView.ItemDecoration {
        val divider = DividerItemDecoration(
            requireContext(),
            DividerItemDecoration.VERTICAL
        )
        divider.setDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.shape_divider_4dp
            )!!
        )
        return divider
    }

    override fun OnItemClick(item: OfferItem) {
        context.showWarningToasty("Not implemented yet!")

        //todo
    }
}