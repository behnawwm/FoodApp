package com.example.foodapp.ui.Home.fragments.menu

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentFoodPreviewBinding


class FoodPreviewFragment : Fragment(R.layout.fragment_food_preview) {
    lateinit var binding: FragmentFoodPreviewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodPreviewBinding.inflate(inflater)

        binding.apply {
            fabFoodPreview.backgroundTintList =
                resources.getColorStateList(R.color.tint_orange)
//            toolbar.background = resources.getDrawable(R.color.white)

        }

        return binding.root
    }

}