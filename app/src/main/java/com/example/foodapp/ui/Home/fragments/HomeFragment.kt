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
import com.example.foodapp.databinding.ItemCustomFixedSizeLayout1Binding
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


        ////////  Carousel 1
        binding.imageCarousel1.registerLifecycle(lifecycle)
        binding.imageCarousel1.carouselListener = object : CarouselListener {
            override fun onCreateViewHolder(
                layoutInflater: LayoutInflater,
                parent: ViewGroup
            ): ViewBinding? {
                return ItemCustomFixedSizeLayout1Binding.inflate(
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
                val currentBinding = binding as ItemCustomFixedSizeLayout1Binding

                currentBinding.tvTitle.text = item.caption ?: ""
                currentBinding.imageView.apply {
                    scaleType = ImageView.ScaleType.CENTER_CROP
                    setImage(item, R.drawable.ic_basket)
                }
            }
        }
        val listCarousel1 = mutableListOf<CarouselItem>()
        val carousel1DataSet = listOf(
            R.drawable.photo_hamburger to "Smokin' Burger",
            R.drawable.photo_cappuccino to "Beef Masala Curry",
            R.drawable.photo_donuts to "Egg Curry",
            R.drawable.photo_steak to "Mixed Juice",
            R.drawable.photo_pizza to "Cheese Sandwich",
            R.drawable.photo_pancakes to "Ice Cream",
        )
        for (item in carousel1DataSet) {
            listCarousel1.add(
                CarouselItem(
                    imageDrawable = item.first,
                    caption = item.second
                )
            )
        }
        binding.imageCarousel1.setData(listCarousel1)


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

                currentBinding.tvTitle.text = item.caption ?: ""
                currentBinding.imageView.apply {
                    scaleType = ImageView.ScaleType.CENTER_CROP
                    setImage(item, R.drawable.ic_basket)
                }
                currentBinding.tvRating.text =
                    "%.1f".format(Random.nextDouble(2.0, 5.0))
            }
        }
        val listCarousel2 = mutableListOf<CarouselItem>()
        val carousel2DataSet = listOf(
            R.drawable.photo_hamburger to "Smokin' Burger",
            R.drawable.photo_cappuccino to "Beef Masala Curry",
            R.drawable.photo_donuts to "Egg Curry",
            R.drawable.photo_steak to "Mixed Juice",
            R.drawable.photo_pizza to "Cheese Sandwich",
            R.drawable.photo_pancakes to "Ice Cream",
        )
        for (item in carousel2DataSet) {
            listCarousel2.add(
                CarouselItem(
                    imageDrawable = item.first,
                    caption = item.second
                )
            )
        }
        binding.imageCarousel2.setData(listCarousel2)



        //////  Image Carousel 3
        binding.imageCarousel3.registerLifecycle(lifecycle)
        binding.imageCarousel3.carouselListener = object : CarouselListener {
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

                currentBinding.tvTitle.text = item.caption ?: ""
                currentBinding.imageView.apply {
                    scaleType = ImageView.ScaleType.CENTER_CROP
                    setImage(item, R.drawable.ic_basket)
                }
                currentBinding.tvRating.text =
                    "%.1f".format(Random.nextDouble(2.0, 5.0))
            }
        }
        val listCarousel3 = mutableListOf<CarouselItem>()
        val carousel3DataSet = listOf(
            R.drawable.photo_mozzarella_sticks to "Smokin' Burger",
            R.drawable.photo_nachos to "Beef Masala Curry",
            R.drawable.photo_soda to "Egg Curry",
            R.drawable.photo_steak to "Mixed Juice",
            R.drawable.photo_waffles to "Cheese Sandwich",
            R.drawable.photo_pizza to "Ice Cream",
        )
        for (item in carousel3DataSet) {
            listCarousel3.add(
                CarouselItem(
                    imageDrawable = item.first,
                    caption = item.second
                )
            )
        }
        binding.imageCarousel3.setData(listCarousel3)


        //////


        return binding.root
    }
}