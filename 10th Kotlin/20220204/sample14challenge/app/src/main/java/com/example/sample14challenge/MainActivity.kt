package com.example.sample14challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpSpinnerFruit()
        setUpSpinnerHandler()
    }

    // val fruits = arrayOf("select fruits", "복숭아", "딸기", "수박", "배", "무화과")

    fun setUpSpinnerFruit() {
        val fruits = resources.getStringArray(R.array.fruits)
        val adapter = ArrayAdapter(this, R.layout.item_spinner, fruits)
        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.adapter = adapter
    }

    fun setUpSpinnerHandler() {
        val spinner = findViewById<Spinner>(R.id.spinner)
        val textView = findViewById<TextView>(R.id.textView)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                textView.text = "selected item is $position ${spinner.getItemAtPosition(position)}"
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}