package com.example.sample12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import com.example.sample12.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContentView(binding.root)
//        binding.checkBox.setOnCheckedChangeListener(checkListener)

        // traditional
        setContentView(R.layout.activity_main)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val textView = findViewById<TextView>(R.id.textView)

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                textView.text = "checked!!"
            } else {
                textView.text = "unChecked!!"
            }
        }
    }

    val checkListener by lazy {
        // CompoundButton으로 모든 버튼 요소에 접근 가능
        CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            val checkBox = findViewById<CheckBox>(R.id.checkBox)
            val textView = findViewById<TextView>(R.id.textView)

            if (isChecked) {
                when (buttonView.id) {
                    R.id.checkBox -> {
                        textView.text = "checked!!"
                    }
                }
            } else {
                when (buttonView.id) {
                    R.id.checkBox -> {
                        textView.text = "unChecked!!"
                    }
                }
            }
        }
    }
}
