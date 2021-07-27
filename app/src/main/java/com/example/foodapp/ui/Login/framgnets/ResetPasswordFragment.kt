package com.example.foodapp.ui.Login.framgnets

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodapp.ui.Intro.IntroActivity
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentResetPasswordBinding


class ResetPasswordFragment : Fragment(R.layout.fragment_reset_password) {
    lateinit var binding: FragmentResetPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResetPasswordBinding.inflate(inflater)

        binding.apply {
            btnConfirmPassword.setOnClickListener {
                startActivity(Intent(requireActivity(), IntroActivity::class.java))
            }
        }

        return binding.root
    }

}