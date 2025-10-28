package com.example.orderfoodapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {

    private val makanan = arrayOf(
        "Combro Bandung",
        "Balager Bandung",
        "Seblak Ceker",
        "Nasi Goreng Spesial",
        "Batagor Bandung",
        "Cilok Goang",
        "Mie Kocok",
        "Surabi Bandung",
        "Karedok Sunda",
        "Sate Maranggi"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
        val username = sharedPref.getString("username", "User")

        tvWelcome.text = "Halo $username,"

        val listMenu = findViewById<ListView>(R.id.listMenu)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, makanan)
        listMenu.adapter = adapter

        listMenu.setOnItemClickListener { _, _, position, _ ->
            val selectedFood = makanan[position]
            val intent = Intent(this, OrderActivity::class.java)
            intent.putExtra("makanan", selectedFood)
            startActivity(intent)
        }
    }
}
