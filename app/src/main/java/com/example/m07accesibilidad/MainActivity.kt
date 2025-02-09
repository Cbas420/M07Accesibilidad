package com.example.m07accesibilidad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.View.GONE
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.ProgressBar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.activity.enableEdgeToEdge


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnOk = findViewById<Button>(R.id.BtnAccess)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)


        btnOk.setOnClickListener() {
            val intent = Intent(this, AppActivity::class.java)
            progressBar.visibility = VISIBLE
            btnOk.visibility = GONE
            //intent.putExtra(projects)
            startActivity(intent)
        }
    }


}