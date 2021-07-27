package com.example.foodapp.ui.Login.framgnets

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.foodapp.ui.Intro.IntroActivity
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentOtpBinding


class OtpFragment : Fragment(R.layout.fragment_otp) {
    lateinit var binding: FragmentOtpBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOtpBinding.inflate(inflater)

        binding.apply {
            tvDontReceive.setText(makeTextSpannable(), TextView.BufferType.SPANNABLE)
            btnNextOtp.setOnClickListener {
                startActivity(Intent(requireActivity(), IntroActivity::class.java))
            }
            otpView.setOtpCompletionListener {
                if (it == "1234")
                    startActivity(Intent(requireActivity(), IntroActivity::class.java))
            }
        }

        return binding.root
    }

    fun makeTextSpannable(): Spannable {
        val hText = "Click Here"
        val pText = "Didn't Receive? "
        val text = pText + hText
        val spannable: Spannable = SpannableString(text)

        spannable.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.orange)),
            pText.length,
            pText.length + hText.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        return spannable
    }

}