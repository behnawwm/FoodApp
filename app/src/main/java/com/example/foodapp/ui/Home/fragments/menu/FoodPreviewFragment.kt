package com.example.foodapp.ui.Home.fragments.menu

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentFoodPreviewBinding
import com.skydoves.powerspinner.IconSpinnerAdapter
import com.skydoves.powerspinner.IconSpinnerItem


class FoodPreviewFragment : Fragment(R.layout.fragment_food_preview) {
    lateinit var binding: FragmentFoodPreviewBinding
    private var isFabActive = false

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodPreviewBinding.inflate(inflater)

        binding.apply {

            nestedScrollView.setOnTouchListener { view, motionEvent ->
                if (motionEvent.action == 2) {
                    spinner1.dismiss()
                    spinner2.dismiss()
                }
                false
            }

            spinner1.apply {
                setSpinnerAdapter(IconSpinnerAdapter(this))
                setItems(
                    arrayListOf(
                        IconSpinnerItem(text = "Big Portion"),
                        IconSpinnerItem(text = "Normal Portion"),
                        IconSpinnerItem(text = "Small Portion")
                    )
                )
                getSpinnerRecyclerView().layoutManager = LinearLayoutManager(context)
                lifecycleOwner = this@FoodPreviewFragment
            }

            spinner2.apply {
                setSpinnerAdapter(IconSpinnerAdapter(this))
                setItems(
                    arrayListOf(
                        IconSpinnerItem(text = "Normal"),
                        IconSpinnerItem(text = "No Veggies"),
                        IconSpinnerItem(text = "No Sausages")
                    )
                )
                getSpinnerRecyclerView().layoutManager = LinearLayoutManager(context)
                lifecycleOwner = this@FoodPreviewFragment
            }
            btnPortionIncrease.setOnClickListener {
                val number = tvNumberPortion.text.toString().toInt()
                tvNumberPortion.text = (number + 1).toString()
            }
            btnPortionDecrease.setOnClickListener {
                val number = tvNumberPortion.text.toString().toInt()
                if (number > 1)
                    tvNumberPortion.text = (number - 1).toString()
            }

            fabFoodPreview.setOnClickListener {    //todo beautification -> extract view util function
                if (isFabActive) {
                    fabFoodPreview.backgroundTintList =
                        resources.getColorStateList(R.color.tint_white)
                    val myFabSrc = resources.getDrawable(R.drawable.ic_star_filled)
                    val willBeWhite = myFabSrc.constantState!!.newDrawable().apply {
                        mutate()
                            .setColorFilter(
                                resources.getColor(R.color.orange),
                                PorterDuff.Mode.MULTIPLY
                            )
                    }
                    fabFoodPreview.setImageDrawable(willBeWhite)
                    isFabActive = false
                } else {
                    fabFoodPreview.backgroundTintList =
                        resources.getColorStateList(R.color.tint_orange)
                    val myFabSrc = resources.getDrawable(R.drawable.ic_star_filled)
                    val willBeWhite = myFabSrc.constantState!!.newDrawable().apply {
                        mutate()
                            .setColorFilter(
                                resources.getColor(R.color.white),
                                PorterDuff.Mode.MULTIPLY
                            )
                    }
                    fabFoodPreview.setImageDrawable(willBeWhite)
                    isFabActive = true
                }
            }
        }

        return binding.root
    }

}