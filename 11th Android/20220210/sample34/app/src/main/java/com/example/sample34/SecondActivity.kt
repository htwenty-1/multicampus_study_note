package com.example.sample34

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import dto.Student

class SecondActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val textView = findViewById<TextView>(R.id.textView)

        val read = findViewById<Button>(R.id.read)
        read.setOnClickListener {
            val student = intent.getParcelableExtra<Student>("student")
            if (student != null) {
                textView.text = "${student.name} ${student.count} ${student.level}"
            }
        }
    }
}