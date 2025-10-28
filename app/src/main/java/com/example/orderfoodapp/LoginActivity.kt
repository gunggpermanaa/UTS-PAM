package com.example.orderfoodapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        db = DatabaseHelper(this)

        val edtUsername = findViewById<EditText>(R.id.edtUsername)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnGoRegister = findViewById<Button>(R.id.btnGoRegister)

        btnLogin.setOnClickListener {
            val username = edtUsername.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            if (db.checkUser(username, password)) {
                // ✅ Simpan username ke SharedPreferences
                val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
                sharedPref.edit().putString("username", username).apply()

                Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MenuActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Username atau password salah, atau belum terdaftar!", Toast.LENGTH_SHORT).show()
            }
        }

        btnGoRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
