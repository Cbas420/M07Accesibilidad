package com.example.m07accesibilidad

import android.content.res.ColorStateList
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class CartFragment : Fragment() {

    private val cartViewModel: CartViewModel by activityViewModels() // Compartir ViewModel
    private lateinit var pay: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
                             ): View? {
        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        val progressValidation = view.findViewById<ProgressBar>(R.id.progressValidation)
        val btnPay = view.findViewById<Button>(R.id.btnPay)
        val txtPay = view.findViewById<TextView>(R.id.txtPay)
        val productContainer =
            view.findViewById<LinearLayout>(R.id.productContainer)

        pay = MediaPlayer.create(requireActivity(), R.raw.pay)

        btnPay.setOnClickListener {
            progressValidation.visibility = VISIBLE
            btnPay.visibility = GONE



            Handler(Looper.getMainLooper()).postDelayed({
                progressValidation.visibility = GONE
                                                            progressValidation.progressTintList =
                                                                ColorStateList.valueOf(Color.GREEN)
                                                            txtPay.visibility = VISIBLE
                                                            pay.start()
                                                            cartViewModel.makePayment()
                                                        }, 2000)



        }

        // Observar cambios en el carrito
        cartViewModel.cartItems.observe(viewLifecycleOwner) { productList ->
            productContainer.removeAllViews() // Limpiar para evitar duplicados

            for (product in productList) {
                val productView =
                    layoutInflater.inflate(R.layout.store_item, productContainer, false)

                val imgProduct = productView.findViewById<ImageView>(R.id.productImageView)
                val txtProductName = productView.findViewById<TextView>(R.id.productNameTextView)
                val txtProductPrice = productView.findViewById<TextView>(R.id.productPriceTextView)

                imgProduct.setImageResource(product.imageResId)
                txtProductName.text = product.name
                txtProductPrice.text = product.price

                productView.setOnLongClickListener {
                    cartViewModel.removeProduct(product)
                    true
                }

                productContainer.addView(productView)
            }
        }



        return view
    }
}
