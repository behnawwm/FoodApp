package com.example.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.foodapp.databinding.ActivityIntroBinding
import com.example.foodapp.databinding.ActivitySignUpBinding
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener
import org.imaginativeworld.whynotimagecarousel.listener.CarouselOnScrollListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class IntroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        val carousel: ImageCarousel = binding.carousel
        carousel.registerLifecycle(lifecycle)
        val list = mutableListOf<CarouselItem>()


        list.add(
            CarouselItem(
                imageDrawable = R.drawable.clipart_find_food_you_love_vector,
                "Discover the best foods from over 1,000\nrestaurants and fast delivery to your doorstep"
            )
        )
        list.add(
            CarouselItem(
                imageDrawable = R.drawable.clipart_delivery_vector,
                "Fast food delivery to your home, office wherever you are"
            )
        )
        list.add(
            CarouselItem(
                imageDrawable = R.drawable.clipart_live_tracking_vector,
                "Real time tracking of your food on the app once you placed the order"
            )
        )
        carousel.setData(list)

        carousel.onScrollListener = object : CarouselOnScrollListener {

            override fun onScrollStateChanged(
                recyclerView: RecyclerView,
                newState: Int,
                position: Int,
                carouselItem: CarouselItem?
            ) {

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    carouselItem?.apply {
                        binding.textView7.text = caption
                    }
                }
            }

            override fun onScrolled(
                recyclerView: RecyclerView,
                dx: Int,
                dy: Int,
                position: Int,
                carouselItem: CarouselItem?
            ) {
                // ...
            }
        }

        carousel.setIndicator(binding.customIndicator)
        binding.btnNext.setOnClickListener {
            carousel.next()
        }

    }
}