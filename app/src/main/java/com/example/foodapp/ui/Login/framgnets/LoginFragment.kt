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
import com.example.foodapp.databinding.FragmentLoginBinding


class LoginFragment : Fragment(R.layout.fragment_login) {
    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater)

        binding.apply {
            btnLoginMain.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_signInFragment)
            }
            btnRegisterMain.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
            }
        }


        return binding.root
    }

}