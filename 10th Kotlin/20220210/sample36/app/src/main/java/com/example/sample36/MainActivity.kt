package com.example.sample36

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // db에 넣어주기
        var dbHelper = DBHelper(this, "testdb.db", null, 1)

        val insertBtn = findViewById<Button>(R.id.insertBtn)
        val editInsert = findViewById<EditText>(R.id.editInsert)
        val wantToEdit = findViewById<EditText>(R.id.wantToEdit)

        val textView = findViewById<TextView>(R.id.textView)
        val readBtn = findViewById<Button>(R.id.readBtn)
        val updateBtn = findViewById<Button>(R.id.updateBtn)
        val deleteBtn = findViewById<Button>(R.id.delBtn)

        val database = dbHelper.writableDatabase
        val db = dbHelper.readableDatabase

        // CREATE
        insertBtn.setOnClickListener {
            val txt = editInsert.text
            dbHelper.insert(database, txt.toString())
        }

        // READ
        readBtn.setOnClickListener {
            val txt = arrayOf(editInsert.text)
            val res:String? = dbHelper.read(db, txt.toString())
            textView.text = res
        }

        // UPDATE
        updateBtn.setOnClickListener {
            val txt = editInsert.text
            val wantEdit = wantToEdit.text
            dbHelper.update(database, txt.toString(), wantEdit.toString())
        }

        // DELETE
        deleteBtn.setOnClickListener {
            val txt = editInsert.text
            dbHelper.delete(database, txt.toString())
        }

    }
}