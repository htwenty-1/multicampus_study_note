package com.example.sample35

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)
        val move = findViewById<Button>(R.id.move)

        move.setOnClickListener {
            // 싱글턴 호출 및 적용
            Singleton.chicken = editText.text.toString()

            // 이동
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }

    }
}