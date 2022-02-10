package com.example.sample36

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // db에 넣어주기
        var dbHelper = DBHelper(this, "testdb.db", null, 1)

        val insertBtn = findViewById<Button>(R.id.insertBtn)
        val editInsert = findViewById<EditText>(R.id.editInsert)

        var database = dbHelper.writableDatabase

        insertBtn.setOnClickListener {
            val txt = editInsert.text
            dbHelper.insert(database, txt.toString())
        }

    }
}