package com.example.m07accesibilidad

import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity

class StoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        val productList = listOf(
            Product(R.drawable.producto1, "Producto 1", "$10.00"),
            Product(R.drawable.producto2, "Producto 2", "$15.00"),
            Product(R.drawable.producto3, "Producto 3", "$20.00"),
            Product(R.drawable.producto1, "Producto 4", "$25.00"),
            Product(R.drawable.producto2, "Producto 5", "$30.00"),
            Product(R.drawable.producto3, "Producto 6", "$35.00")
                                )

        val gridView = findViewById<GridView>(R.id.gridView)
        val adapter = ProductAdapter(this, productList)
        gridView.adapter = adapter
    }
}