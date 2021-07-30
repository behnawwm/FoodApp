package com.example.foodapp.ui.Home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewbinding.ViewBinding
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentHomeBinding
import com.example.foodapp.databinding.ItemCustomFixedSizeLayout2Binding
import com.google.android.material.bottomappbar.BottomAppBar
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import org.imaginativeworld.whynotimagecarousel.utils.setImage
import kotlin.random.Random


class HomeFragment : Fragment(R.layout.fragment_home) {
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)

        requireActivity().findViewById<BottomAppBar>(R.id.bottom_appbar).performShow()

        ////////  Carousel 2
        binding.imageCarousel2.registerLifecycle(lifecycle)
        binding.imageCarousel2.carouselListener = object : CarouselListener {
            override fun onCreateViewHolder(
                layoutInflater: LayoutInflater,
                parent: ViewGroup
            ): ViewBinding? {
                return ItemCustomFixedSizeLayout2Binding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            }
            override fun onBindViewHolder(
                binding: ViewBinding,
                item: CarouselItem,
                position: Int
            ) {
                val currentBinding = binding as ItemCustomFixedSizeLayout2Binding

                currentBinding.tvTitle.text = item.caption ?:""
                currentBinding.imageView.apply {
                    scaleType = ImageView.ScaleType.CENTER_CROP
                    setImage(item, R.drawable.ic_basket)
                }
                currentBinding.tvRating.text =
                    "%.1f".format(Random.nextDouble(2.0, 5.0))
            }
        }
        val listFive = mutableListOf<CarouselItem>()
        val five = listOf(
            R.drawable.photo_hamburger to "Smokin' Burger",
            R.drawable.photo_cappuccino to "Beef Masala Curry",
            R.drawable.photo_donuts to "Egg Curry",
            R.drawable.photo_steak to "Mixed Juice",
            R.drawable.photo_pizza to "Cheese Sandwich",
            R.drawable.photo_pancakes to "Ice Cream",
        )
        for (item in five) {
            listFive.add(
                CarouselItem(
                    imageDrawable = item.first,
                    caption = item.second
                )
            )
        }
        binding.imageCarousel2.setData(listFive)
        //////




        return binding.root
    }
}