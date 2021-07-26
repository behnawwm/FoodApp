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
import com.example.foodapp.databinding.FragmentSignupBinding


class SignUpFragment : Fragment(R.layout.fragment_signup) {
    lateinit var binding: FragmentSignupBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSignupBinding.inflate(inflater)

        val hText = "Login"
        val pText = "Already have an Account? "
        val text = pText + hText
        val spannable: Spannable = SpannableString(text)

        spannable.setSpan(
            ForegroundColorSpan(getColor(requireContext(), R.color.orange)),
            pText.length,
            pText.length + hText.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.tvAlreadyHaveAccountLogin.setText(spannable, TextView.BufferType.SPANNABLE)
        binding.tvAlreadyHaveAccountLogin.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
        }

        binding.btnRegister.setOnClickListener {
            startActivity(Intent(requireActivity(), IntroActivity::class.java))
        }

        return binding.root
    }
}