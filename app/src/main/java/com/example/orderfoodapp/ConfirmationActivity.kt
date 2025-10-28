package com.example.orderfoodapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        val tvSalam = findViewById<TextView>(R.id.tvSalam)
        val btnKirim = findViewById<Button>(R.id.btnKirim)

        val nama = intent.getStringExtra("nama")
        val alamat = intent.getStringExtra("alamat")
        val patokan = intent.getStringExtra("patokan")

        tvSalam.text = "Halo $nama,"

        btnKirim.setOnClickListener {
            Toast.makeText(
                this,
                "Pesanan dikirim ke alamat: $alamat ($patokan)",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
