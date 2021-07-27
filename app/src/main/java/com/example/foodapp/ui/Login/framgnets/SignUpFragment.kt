package com.example.foodapp.ui.Login.framgnets

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
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentSignupBinding


class SignUpFragment : Fragment(R.layout.fragment_signup) {
    lateinit var binding: FragmentSignupBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupBinding.inflate(inflater)

        binding.apply {
            tvAlreadyHaveAccountLogin.setText(
                makeTextSpannable(),
                TextView.BufferType.SPANNABLE
            )
            tvAlreadyHaveAccountLogin.setOnClickListener {
                findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
            }
            btnRegister.setOnClickListener {
                findNavController().navigate(R.id.action_signUpFragment_to_otpFragment)
            }
        }

        return binding.root
    }

    fun makeTextSpannable(): Spannable {
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
        return spannable
    }
}