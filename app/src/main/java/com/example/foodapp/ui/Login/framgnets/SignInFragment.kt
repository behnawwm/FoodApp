package com.example.foodapp.ui.Login.framgnets

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.navigation.fragment.findNavController
import com.example.foodapp.ui.Intro.IntroActivity
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentSigninBinding
import com.example.foodapp.ui.Home.HomeActivity


class SignInFragment : Fragment(R.layout.fragment_signin) {
    lateinit var binding: FragmentSigninBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSigninBinding.inflate(inflater)

        binding.apply {
            tvDontHaveAccount.setText(makeSpannableText(), TextView.BufferType.SPANNABLE)
            tvDontHaveAccount.setOnClickListener {
                findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
            }
            btnLogin.setOnClickListener {
                startActivity(Intent(requireActivity(), HomeActivity::class.java))
                requireActivity().finish()
            }
            btnLoginFacebook.setOnClickListener {
                startActivity(Intent(requireActivity(), HomeActivity::class.java))
                requireActivity().finish()
            }
            btnLoginGoogle.setOnClickListener {
                startActivity(Intent(requireActivity(), HomeActivity::class.java))
                requireActivity().finish()
            }
            tvForgotPassword.setOnClickListener {
                findNavController().navigate(R.id.action_signInFragment_to_forgotPasswordFragment)
            }
        }


        return binding.root
    }

    fun makeSpannableText(): Spannable {
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
        return spannable
    }
}