package com.example.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.foodapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.background = null
        binding.bottomNavigation.menu.getItem(2).isEnabled = false
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
        )


//        binding.bottomNavigation.setOnNavigationItemReselectedListener { item ->
//            when (item.itemId) {
//                R.id.menu_menu -> {
//                    // Respond to navigation item 1 reselection
//                }
//                R.id.menu_offers -> {
//                    // Respond to navigation item 2 reselection
//                }
//                R.id.menu_home -> {
//                    // Respond to navigation item 3 reselection
//                }
//                R.id.menu_profile -> {
//                    // Respond to navigation item 4 reselection
//                }
//                R.id.menu_more -> {
//                    // Respond to navigation item 5 reselection
//                }
//            }
//        }
    }
}