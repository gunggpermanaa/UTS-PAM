package com.example.orderfoodapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tombol untuk mulai ke menu makanan (Screen 5)
        val btnStartNow = findViewById<Button>(R.id.btnStartNow)
        btnStartNow.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}
