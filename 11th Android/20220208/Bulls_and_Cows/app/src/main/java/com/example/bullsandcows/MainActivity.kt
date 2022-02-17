package com.example.bullsandcows

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var baseball:Baseball? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initSpinnerItems()

        baseball = Baseball()
        baseball!!.random()

        val btn = findViewById<Button>(R.id.playButton)
        btn.setOnClickListener {
            action()
        }


    }

    // 스피너 초기화
    fun initSpinnerItems() {
        val spinnerArray = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
        val adapter = ArrayAdapter(this, R.layout.spinner_item, spinnerArray)

        val firstSpinner = findViewById<Spinner>(R.id.firstNumSpinner)
        val secondSpinner = findViewById<Spinner>(R.id.secondNumSpinner)
        val thirdSpinner = findViewById<Spinner>(R.id.thirdNumSpinner)

        firstSpinner.adapter = adapter
        secondSpinner.adapter = adapter
        thirdSpinner.adapter = adapter
    }

    fun action() {
        val firstSpinner = findViewById<Spinner>(R.id.firstNumSpinner)
        val secondSpinner = findViewById<Spinner>(R.id.secondNumSpinner)
        val thirdSpinner = findViewById<Spinner>(R.id.thirdNumSpinner)

        val firstNumber = firstSpinner.selectedItem.toString().toInt()
        val secondNumber = secondSpinner.selectedItem.toString().toInt()
        val thirdNumber = thirdSpinner.selectedItem.toString().toInt()

        var spinnerArr = arrayOf<Int>(firstNumber, secondNumber, thirdNumber)

        val res:Result? = baseball?.finding(spinnerArr)

        val textView = findViewById<TextView>(R.id.resultOfGame)
        if (res != null) {
            if (res.strike == 3) {
                baseball?.clear = true
                textView.text = baseball?.resultString()
            } else {
                textView.text = "${res.strike} Strike ${res.ball} Ball"
            }
        }

    }

}