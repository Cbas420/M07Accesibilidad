package com.example.m07accesibilidad

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.Toast

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class StoreFragment : Fragment() {

    private lateinit var add: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout del fragmento
        val view = inflater.inflate(R.layout.fragment_store, container, false)

        add = MediaPlayer.create(requireActivity(), R.raw.add)

        // Crear la lista de productos
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

        // Configurar el GridView y el adapter
        val gridView = view.findViewById<GridView>(R.id.gridView)
        val adapter = ProductsAdapter(requireContext(), productList, this)
        gridView.adapter = adapter

        return view
    }

    fun onItemClick(product: Product) {
        add.start()
        Toast.makeText(context, "Clic en: ${product.name}", Toast.LENGTH_SHORT).show()
    }
}