package com.example.orderfoodapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val tvHalo = findViewById<TextView>(R.id.tvHalo)
        val tvHasilPesanan = findViewById<TextView>(R.id.tvHasilPesanan)
        val btnKirim = findViewById<Button>(R.id.btnKirim)

        // 🔹 Ambil username dari SharedPreferences
        val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
        val username = sharedPref.getString("username", "User")

        // 🔹 Ambil data makanan dari intent
        val makanan = intent.getStringExtra("makanan") ?: "Tidak ada pesanan"

        // 🔹 Tampilkan data ke layar
        tvHalo.text = "Halo $username,"
        tvHasilPesanan.text = makanan

        // 🔹 Tombol Kirim ditekan
        btnKirim.setOnClickListener {
            Toast.makeText(this, "Pesanan $makanan berhasil dikirim!", Toast.LENGTH_SHORT).show()

            // Pindah ke halaman alamat (screen 7)
            val intent = Intent(this, AddressActivity::class.java)
            intent.putExtra("username", username)
            intent.putExtra("makanan", makanan)
            startActivity(intent)
            finish()
        }
    }
}
