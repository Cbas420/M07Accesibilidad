package com.example.m07accesibilidad

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        val progressValidation = view.findViewById<ProgressBar>(R.id.progressValidation)
        val btnPay = view.findViewById<Button>(R.id.btnPay)
        val txtPay = view.findViewById<TextView>(R.id.txtPay)

        btnPay.setOnClickListener {
            progressValidation.visibility = VISIBLE
            btnPay.visibility = GONE

            Handler(Looper.getMainLooper()).postDelayed({
                progressValidation.visibility = GONE
                progressValidation.progressTintList = ColorStateList.valueOf(Color.GREEN)
                txtPay.visibility = VISIBLE
            }, 2000)
        }

        return view
    }
}