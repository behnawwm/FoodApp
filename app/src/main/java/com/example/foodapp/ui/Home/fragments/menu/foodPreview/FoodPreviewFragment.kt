package com.example.foodapp.ui.Home.fragments.menu.foodPreview

import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.R
import com.example.foodapp.Utils.ViewUtils.setFabIcon
import com.example.foodapp.databinding.FragmentFoodPreviewBinding
import com.example.foodapp.ui.Home.fragments.menu.menuPreview.MenuPreviewFragmentArgs
import com.skydoves.powerspinner.IconSpinnerAdapter
import com.skydoves.powerspinner.IconSpinnerItem


class FoodPreviewFragment : Fragment(R.layout.fragment_food_preview) {
    lateinit var binding: FragmentFoodPreviewBinding
    private var isFabActive = false
    private val args: FoodPreviewFragmentArgs by navArgs()

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodPreviewBinding.inflate(inflater)

        binding.apply {
            ivFoodPreview.setImageResource(args.selectedMenuPreviewItem.photoDrawable)
            tvTitle.text = args.selectedMenuPreviewItem.title
            ratingBar.rating = args.selectedMenuPreviewItem.rating.toFloat()
            tvFoodPrice.text = "$ " + args.selectedMenuPreviewItem.price.toString()
            tvTotalPrice.text = "$ " + args.selectedMenuPreviewItem.price.toString()

            setUpSpinner1()
            setUpSpinner2()

            nestedScrollView.setOnTouchListener { view, motionEvent ->
                if (motionEvent.action == MotionEvent.ACTION_MOVE) {
                    spinner1.dismiss()
                    spinner2.dismiss()
                }
                false
            }

            btnPortionIncrease.setOnClickListener {
                val number = tvNumberPortion.text.toString().toInt() + 1
                tvNumberPortion.text = number.toString()
                tvTotalPrice.text = "$ " + (args.selectedMenuPreviewItem.price * number)
            }
            btnPortionDecrease.setOnClickListener {
                val number = tvNumberPortion.text.toString().toInt() - 1
                if (number > 0) {
                    tvNumberPortion.text = number.toString()
                    tvTotalPrice.text = "$ " + (args.selectedMenuPreviewItem.price * number)
                }
            }

            fabFoodPreview.setOnClickListener {
                if (isFabActive) {
                    fabFoodPreview.setFabIcon(
                        R.color.tint_white,
                        R.color.orange,
                        R.drawable.ic_star_filled
                    )
                    isFabActive = false
                } else {
                    fabFoodPreview.setFabIcon(
                        R.color.tint_orange,
                        R.color.white,
                        R.drawable.ic_star_filled
                    )
                    isFabActive = true
                }
            }
        }

        binding.toolbarFoodPreview.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.cart -> {
                    //todo
                }
            }
            true
        }
        binding.toolbarFoodPreview.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        return binding.root
    }

    private fun setUpSpinner2() {
        binding.spinner2.apply {
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
    }

    private fun setUpSpinner1() {
        binding.spinner1.apply {
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
    }
}