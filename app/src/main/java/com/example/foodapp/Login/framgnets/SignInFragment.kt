package com.example.foodapp.Login.framgnets

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.navigation.fragment.findNavController
import com.example.foodapp.Intro.IntroActivity
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentLoginBinding
import com.example.foodapp.databinding.FragmentSigninBinding


class SignInFragment : Fragment(R.layout.fragment_signin) {
    lateinit var binding: FragmentSigninBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSigninBinding.inflate(inflater)

        val hText = "Sign Up!"
        val pText = "Don't have an Account? "
        val text = pText + hText
        val spannable: Spannable = SpannableString(text)

        spannable.setSpan(
            ForegroundColorSpan(getColor(requireContext(), R.color.orange)),
            pText.length,
            pText.length + hText.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.tvDontHaveAccount.setText(spannable, TextView.BufferType.SPANNABLE)
        binding.tvDontHaveAccount.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(requireActivity(), IntroActivity::class.java))
        }
        binding.btnLoginFacebook.setOnClickListener {
            startActivity(Intent(requireActivity(), IntroActivity::class.java))
        }
        binding.btnLoginGoogle.setOnClickListener {
            startActivity(Intent(requireActivity(), IntroActivity::class.java))
        }
        binding.tvForgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_forgotPasswordFragment)
        }


        return binding.root
    }
}