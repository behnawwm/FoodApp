package com.example.foodapp.ui.Home

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.forEach
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.foodapp.R
import com.example.foodapp.Utils.ContextUtils.showWarningToasty
import com.example.foodapp.databinding.ActivityHomeBinding
import com.github.dhaval2404.imagepicker.ImagePicker


class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.findNavController()
        ///// appbar
        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(
                R.id.menuFragment, R.id.offersFragment,
                R.id.homeFragment, R.id.moreFragment,
                R.id.profileFragment
            ),
            fallbackOnNavigateUpListener = ::onSupportNavigateUp
        )
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
        ////////


        binding.apply {
            bottomNavigation.background = null
            bottomNavigation.menu.getItem(2).isEnabled = false

            bottomNavigation.setOnNavigationItemSelectedListener {
                fabHome.backgroundTintList = resources.getColorStateList(R.color.tint_gray_disabled)
                when (it.itemId) {
                    R.id.menu_menu -> {
                        navController.navigate(R.id.action_global_menuFragment)
                    }
                    R.id.menu_offers -> {
                        navController.navigate(R.id.action_global_offersFragment)
                    }
                    R.id.menu_profile -> {
                        navController.navigate(R.id.action_global_profileFragment)
                    }
                    R.id.menu_more -> {
                        navController.navigate(R.id.action_global_moreFragment)
                    }
                }
                true
            }

            fabHome.setOnClickListener {
                fabHome.backgroundTintList = resources.getColorStateList(R.color.tint_orange)
                bottomNavigation.menu.forEach {
                    if (it.isChecked)
                        bottomNavigation.selectedItemId = R.id.menu_placeholder
                }
                navController.navigate(R.id.action_global_homeFragment)
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
            R.id.cart -> baseContext.showWarningToasty("Not implemented yet!")
        }
        return true
    }
}