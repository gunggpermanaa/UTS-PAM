package com.example.orderfoodapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        db = DatabaseHelper(this)

        val edtUsername = findViewById<EditText>(R.id.edtUsername)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val btnGoLogin = findViewById<Button>(R.id.btnGoLogin)

        btnRegister.setOnClickListener {
            val username = edtUsername.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Isi semua data!", Toast.LENGTH_SHORT).show()
            } else if (db.checkUsername(username)) {
                Toast.makeText(this, "Username sudah terdaftar!", Toast.LENGTH_SHORT).show()
            } else {
                val insert = db.insertUser(username, password)
                if (insert) {
                    // ✅ Simpan username ke SharedPreferences
                    val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
                    sharedPref.edit().putString("username", username).apply()

                    Toast.makeText(this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Gagal menyimpan data!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnGoLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
