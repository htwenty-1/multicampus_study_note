package com.example.sample27

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgBtn = findViewById<ImageButton>(R.id.imageButton)
        // xml에 onClick을 쓰지 않아도 됨
        imgBtn.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val textView = findViewById<TextView>(R.id.textView)

        when(v?.id) {
            R.id.imageButton -> {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("button is clicked")
                builder.setMessage("Image Button Clicked!!")
                builder.show()
                textView.text = "Image Button Clicked!!!"
            }
        }

    }
}