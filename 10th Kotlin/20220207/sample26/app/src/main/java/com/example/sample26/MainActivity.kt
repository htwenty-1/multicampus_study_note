package com.example.sample26

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RatingBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val textView = findViewById<View>(R.id.textView) as TextView
        ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            textView.text = "$rating"
        }
    }
}