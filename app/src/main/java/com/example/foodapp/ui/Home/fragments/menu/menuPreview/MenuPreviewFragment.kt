package com.example.foodapp.ui.Home.fragments.menu.menuPreview

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.data.TestDataSet
import com.example.foodapp.data.models.MenuPreviewItem
import com.example.foodapp.databinding.FragmentMenuPreviewBinding


class MenuPreviewFragment : Fragment(R.layout.fragment_menu_preview),
    MenuPreviewItemsAdapter.OnItemPressListener {
    lateinit var binding: FragmentMenuPreviewBinding
    private val args: MenuPreviewFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuPreviewBinding.inflate(inflater)

        val offersAdapter = MenuPreviewItemsAdapter(this).apply {
            when (args.selectedMenuTitle) {
                "Foods" -> submitList(TestDataSet.provideFoodTestDataSet())
                "Desserts" -> submitList(TestDataSet.provideDessertsTestDataSet())
                "Beverages" -> submitList(TestDataSet.provideBeveragesTestDataSet())
                "Appetizers" -> submitList(TestDataSet.provideAppetizersTestDataSet())
            }
        }
        binding.apply {
            rvOffers.setHasFixedSize(true)
            rvOffers.adapter = offersAdapter
            rvOffers.addItemDecoration(initRecyclerDivider())
        }

        requireActivity().actionBar?.title = args.selectedMenuTitle
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

    override fun OnItemClick(item: MenuPreviewItem) {
        findNavController().navigate(
            MenuPreviewFragmentDirections.actionMenuPreviewFragmentToFoodPreviewFragment(
                item
            )
        )
    }


}