package com.example.foodapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.lifecycle.lifecycleScope
import com.example.foodapp.R
import com.example.foodapp.ui.Intro.IntroActivity
import com.example.foodapp.ui.Login.LoginActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        lifecycleScope.launch {
            delay(500)
            startActivity(Intent(this@SplashActivity, IntroActivity::class.java))
            finish()
        }

    }
}