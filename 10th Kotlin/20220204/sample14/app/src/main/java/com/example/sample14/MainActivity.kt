package com.example.sample14

import android.annotation.SuppressLint
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

        setUpSpinnerFruits()
        setUpSpinnerHandler()
    }

    // 스피너 초기화(값 설정) - initialize
    fun setUpSpinnerFruits() {
        // 스피너 아이템에 추가할 항목
        // val fruits = arrayOf("과일 선택", "사과", "배", "바나나", "포도")
        val fruits = resources.getStringArray(R.array.fruits)
        val adapter = ArrayAdapter(this, R.layout.item_spinner, fruits)     // fruits 배열의 각 인덱스마다 Adapter 적용

        // spinner에 적용
        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.adapter = adapter
    }

    // 스피너 아이템 선택 감지 및 출력
    fun setUpSpinnerHandler() {
        val spinner = findViewById<Spinner>(R.id.spinner)
        val textView = findViewById<TextView>(R.id.textView)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            @SuppressLint("SetTextI18n")
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                textView.text = "selected: $position ${spinner.getItemAtPosition(position)}"
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

}