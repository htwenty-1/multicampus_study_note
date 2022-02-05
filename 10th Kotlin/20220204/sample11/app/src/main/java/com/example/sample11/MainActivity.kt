package com.example.sample11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioGroup
import android.widget.TextView
import com.example.sample11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 컴포넌트에 자유롭게 접근 가능
    // val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {

        /*
        // ActivityMainBiding을 사용할 때 setContentView를 아래와 같이 사용한다.
        setContentView(binding.root)

        // 실시간으로 바뀌는 값 가져오기
        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            Log.d(" ", "RadioButton is Clicked")
            when (checkedId) {
                R.id.radio1 -> {
                    binding.textView.text = "Apple is selected"
                    Log.d(" ", "Apple is selected")
                }
                R.id.radio2 -> {
                    binding.textView.text = "Banana is selected"
                    Log.d(" ", "Banana is selected")
                }
                R.id.radio3 -> {
                    binding.textView.text = "Orange is selected"
                    Log.d(" ", "Orange is selected")
                }
            }
        }
        */

        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)

        // id로 접근하기
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val textView = findViewById<TextView>(R.id.textView)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            Log.d(" ", "RadioButton is Clicked")
            when (checkedId) {
                R.id.radio1 -> {
                    textView.text = "Apple is selected"
                    Log.d(" ", "Apple is selected")
                }
                R.id.radio2 -> {
                    textView.text = "Banana is selected"
                    Log.d(" ", "Banana is selected")
                }
                R.id.radio3 -> {
                    textView.text = "Orange is selected"
                    Log.d(" ", "Orange is selected")
                }
            }
        }
    }
}