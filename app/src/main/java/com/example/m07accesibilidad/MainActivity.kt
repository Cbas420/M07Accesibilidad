package com.example.m07accesibilidad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.activity.enableEdgeToEdge


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnOk = findViewById<Button>(R.id.BtnAccess)

        btnOk.setOnClickListener() {
            val intent = Intent(this, AppActivity::class.java)
            //intent.putExtra(projects)
            startActivity(intent)
        }
    }


}