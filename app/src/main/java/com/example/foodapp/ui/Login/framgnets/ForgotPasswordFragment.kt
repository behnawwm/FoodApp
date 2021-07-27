package com.example.foodapp.ui.Login.framgnets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.foodapp.R
import com.example.foodapp.databinding.ActivityLoginBinding
import com.example.foodapp.databinding.FragmentForgotPasswordBinding
import com.example.foodapp.databinding.FragmentLoginBinding


class ForgotPasswordFragment : Fragment(R.layout.fragment_forgot_password) {
    lateinit var binding: FragmentForgotPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForgotPasswordBinding.inflate(inflater)

        binding.btnResetPassword.setOnClickListener {
            findNavController().navigate(R.id.action_forgotPasswordFragment_to_resetPasswordFragment)
        }

        return binding.root
    }

}