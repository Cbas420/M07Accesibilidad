package com.example.m07accesibilidad

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class AppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, StoreFragment())
                .commit()
        }

        val storeButton = findViewById<Button>(R.id.storeButton)
        val cartButton = findViewById<Button>(R.id.cartButton)

        // Navegación entre fragmentos
        storeButton.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, StoreFragment())
                .addToBackStack(null)  // Agrega al back stack
                .commit()
            storeButton.setBackgroundColor(ContextCompat.getColor(this, R.color.orange))
            cartButton.setBackgroundColor(ContextCompat.getColor(this, R.color.gray))
        }

        cartButton.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, CartFragment())
                .addToBackStack(null)  // Agrega al back stack
                .commit()
            storeButton.setBackgroundColor(ContextCompat.getColor(this, R.color.gray))
            cartButton.setBackgroundColor(ContextCompat.getColor(this, R.color.orange))
        }


    }
}