package com.example.m07accesibilidad

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.Toast
import androidx.fragment.app.activityViewModels

class StoreFragment : Fragment() {

    private val cartViewModel: CartViewModel by activityViewModels() // Compartir ViewModel
    private lateinit var add: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
                             ): View? {
        val view = inflater.inflate(R.layout.fragment_store, container, false)

        add = MediaPlayer.create(requireActivity(), R.raw.add)

        val productList = listOf(
            Product(R.drawable.producto1, "Manzana", "$10.00"),
            Product(R.drawable.producto2, "Pera", "$15.00"),
            Product(R.drawable.producto3, "Zanahoria", "$20.00"),
            Product(R.drawable.producto1, "Manzana", "$25.00"),
            Product(R.drawable.producto2, "Pera", "$30.00"),
            Product(R.drawable.producto3, "Zanahoria", "$35.00"),
            Product(R.drawable.producto3, "Zanahoria", "$35.00"),
            Product(R.drawable.producto3, "Zanahoria", "$35.00"),
            Product(R.drawable.producto3, "Zanahoria", "$35.00"),
            Product(R.drawable.producto3, "Zanahoria", "$35.00")
                                )

        val gridView = view.findViewById<GridView>(R.id.gridView)
        val adapter = ProductsAdapter(requireContext(), productList, this)
        gridView.adapter = adapter

        return view
    }

    fun onItemClick(product: Product) {
        add.start()
        Toast.makeText(context, "Añadido al carrito: ${product.name}", Toast.LENGTH_SHORT).show()
        cartViewModel.addProduct(product) // Agregar producto al carrito
    }
}
