package com.example.foodapp.ui.Intro

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.ui.Home.HomeActivity
import com.example.foodapp.R
import com.example.foodapp.data.models.IntroSliderData
import com.example.foodapp.databinding.ActivityIntroBinding
import com.example.foodapp.ui.Login.LoginActivity
import org.imaginativeworld.whynotimagecarousel.listener.CarouselOnScrollListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem


class IntroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        val introDataSet = provideTestIntroDataSet()
        val introList = mutableListOf(
            CarouselItem(introDataSet[0].photo, "0"),
            CarouselItem(introDataSet[1].photo, "1"),
            CarouselItem(introDataSet[2].photo, "2")
        )

        binding.apply {
            carousel.registerLifecycle(lifecycle)
            carousel.setData(introList)
            carousel.currentPosition = 0
            carousel.setIndicator(customIndicator)

            carousel.onScrollListener = object : CarouselOnScrollListener {
                override fun onScrollStateChanged(
                    recyclerView: RecyclerView,
                    newState: Int,
                    position: Int,
                    carouselItem: CarouselItem?
                ) {
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        carouselItem?.apply {
//                        val transitionsContainer = binding.constraintLayout   //todo animation lag
//                        TransitionManager.beginDelayedTransition(
//                            transitionsContainer,
//                            ChangeText().setChangeBehavior(ChangeText.CHANGE_BEHAVIOR_OUT_IN)
//                        )
                            textView7.text = introDataSet[this.caption!!.toInt()].desc
                            textView6.text = introDataSet[this.caption!!.toInt()].title

                            if (position == 2)
                                btnIntroNext.text = "Let's Go!"
                            else
                                btnIntroNext.text = "Next"
                        }
                    }
                }
            }

            btnIntroNext.setOnClickListener {
                if (carousel.currentPosition % introDataSet.size == 2) {  //todo library bug
                    startActivity(Intent(this@IntroActivity, LoginActivity::class.java))
                    finish()
                } else
                    carousel.currentPosition++

            }
        }

    }

    private fun provideTestIntroDataSet(): List<IntroSliderData> {
        return listOf(
            IntroSliderData(
                1,
                "Find Food You Love",
                "Discover the best foods from over 1,000 restaurants and fast delivery to your doorstep",
                R.drawable.clipart_find_food_you_love_vector
            ),
            IntroSliderData(
                2,
                "Fast Delivery",
                "Fast food delivery to your home, office wherever you are",
                R.drawable.clipart_delivery_vector
            ),
            IntroSliderData(
                3,
                "Live Tracking",
                "Real time tracking of your food on the app once you placed the order",
                R.drawable.clipart_live_tracking_vector
            ),
        )

    }
}