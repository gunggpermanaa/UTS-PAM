package com.example.orderfoodapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "UserDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE users(id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun insertUser(username: String, password: String): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("username", username)
        values.put("password", password)
        val result = db.insert("users", null, values)
        db.close()
        return result != -1L
    }

    fun checkUser(username: String, password: String): Boolean {
        val db = this.readableDatabase
        val cursor: Cursor = db.rawQuery(
            "SELECT * FROM users WHERE username=? AND password=?",
            arrayOf(username, password)
        )
        val exists = cursor.count > 0
        cursor.close()
        db.close()
        return exists
    }

    fun checkUsername(username: String): Boolean {
        val db = this.readableDatabase
        val cursor: Cursor = db.rawQuery(
            "SELECT * FROM users WHERE username=?",
            arrayOf(username)
        )
        val exists = cursor.count > 0
        cursor.close()
        db.close()
        return exists
    }
}
