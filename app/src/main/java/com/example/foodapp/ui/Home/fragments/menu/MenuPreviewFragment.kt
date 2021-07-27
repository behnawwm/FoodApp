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
import com.example.foodapp.databinding.FragmentMenuBinding
import com.example.foodapp.databinding.FragmentMenuPreviewBinding
import com.example.foodapp.ui.Home.fragments.offers.OffersAdapter


class MenuPreviewFragment : Fragment(R.layout.fragment_menu_preview),
    MenuPreviewItemsAdapter.OnItemPressListener {
    lateinit var binding: FragmentMenuPreviewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuPreviewBinding.inflate(inflater)

        val offersAdapter = MenuPreviewItemsAdapter(this).apply {
            submitList(provideTestDataSet())
        }
        binding.apply {
            rvOffers.setHasFixedSize(true)
            rvOffers.adapter = offersAdapter
            rvOffers.addItemDecoration(initRecyclerDivider())

        }

        return binding.root
    }

    private fun provideTestDataSet(): MutableList<MenuPreviewItem>? {
        return mutableListOf(
            MenuPreviewItem(0, "Pizza", 4.8, 123, "Desserts", "Paris"),
            MenuPreviewItem(1, "Hamburger", 3.5, 231, "Fast Food", "London"),
            MenuPreviewItem(2, "Hotdog", 2.1, 3, "Cafe", "Paris"),
            MenuPreviewItem(3, "Salad", 4.9, 41, "Cafe", "Paris"),
            MenuPreviewItem(4, "Beverages", 3.9, 2309, "Cafe", "Paris"),
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

    override fun OnItemClick(item: MenuPreviewItem) {
        //todo
    }
}