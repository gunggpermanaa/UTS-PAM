package com.example.orderfoodapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val startBtn = findViewById<Button>(R.id.btnStart)
        startBtn.setOnClickListener {
            // Pindah ke halaman berikutnya (AuthActivity)
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
