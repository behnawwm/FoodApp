package com.example.foodapp.Home

import android.os.Bundle
import android.view.Menu
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.foodapp.R
import com.example.foodapp.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.background = null
        binding.bottomNavigation.menu.getItem(2).isEnabled = false
//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
//            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
//        )

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.findNavController()


        val appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)
        val toolbar = binding.toolbar
        toolbar.setupWithNavController(navController, appBarConfiguration)
        setSupportActionBar(toolbar)

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_menu -> {
                    navController.navigate(R.id.action_global_menuFragment)
                }
                R.id.menu_offers -> {
                    navController.navigate(R.id.action_global_offersFragment)
                }
//                R.id.menu -> {
//                    // Respond to navigation home reselection
//                }
                R.id.menu_profile -> {
                    navController.navigate(R.id.action_global_profileFragment)
                }
                R.id.menu_more -> {
                    navController.navigate(R.id.action_global_moreFragment)
                }
            }
            true
        }



    }

//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }
}