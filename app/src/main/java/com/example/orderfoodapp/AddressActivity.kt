package com.example.orderfoodapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)

        val etNamaLengkap = findViewById<EditText>(R.id.etNamaLengkap)
        val etAlamat = findViewById<EditText>(R.id.etAlamat)
        val etPatokan = findViewById<EditText>(R.id.etPatokan)
        val btnOrderKirim = findViewById<Button>(R.id.btnOrderKirim)

        // Ambil data makanan dari halaman sebelumnya (jika ada)
        val makanan = intent.getStringExtra("makanan")

        btnOrderKirim.setOnClickListener {
            val nama = etNamaLengkap.text.toString().trim()
            val alamat = etAlamat.text.toString().trim()
            val patokan = etPatokan.text.toString().trim()

            // Validasi: Pastikan semua kolom diisi
            if (nama.isEmpty() || alamat.isEmpty() || patokan.isEmpty()) {
                Toast.makeText(this, "Harap isi semua data terlebih dahulu!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Pindah ke halaman konfirmasi
            val intent = Intent(this, ConfirmationActivity::class.java)
            intent.putExtra("nama", nama)
            intent.putExtra("alamat", alamat)
            intent.putExtra("patokan", patokan)
            intent.putExtra("makanan", makanan)
            startActivity(intent)
        }
    }
}
