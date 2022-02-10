package com.example.sample34

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import dto.Student

// preference는 기본자료형만 보낼 수 있어서...
// intent를 사용하면 객체를 전달해줄 수 있다!
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editName = findViewById<EditText>(R.id.editName)
        val editCount = findViewById<EditText>(R.id.editCount)
        val editLevel = findViewById<EditText>(R.id.editLevel)

        val move = findViewById<Button>(R.id.move)

        move.setOnClickListener {
            var student = Student(editName.text.toString(), editCount.text.toString().toInt(), editLevel.text.toString())
            val nextIntent = Intent(this, SecondActivity::class.java)
            nextIntent.putExtra("student", student)
            startActivity(nextIntent)
        }

    }
}