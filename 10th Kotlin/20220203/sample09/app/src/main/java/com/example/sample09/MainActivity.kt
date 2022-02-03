package com.example.sample09

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.sample09.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity()/*, View.OnClickListener*/ {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)    // 이 코드를 마주했을 때 binding이 초기화(객체화)됨.

        binding.btn.setOnClickListener {
            Toast.makeText(this.applicationContext, "버튼_one 클릭", Toast.LENGTH_SHORT).show()

            binding.btn2.text="시간 출력~"
        }

        /*
        setContentView(R.layout.activity_main)

        val btn2 = findViewById<Button>(R.id.btn2)
        btn2.setOnClickListener {
            Toast.makeText(this.applicationContext, "버튼2 클릭", Toast.LENGTH_SHORT).show()
        }
        */
    }

    /*
    @SuppressLint("SimpleDateFormat")
    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btn -> {
                Log.d("버튼", "클릭")

                val btn2 = findViewById<Button>(R.id.btn2)
                btn2.text = SimpleDateFormat("yyyy-MM-dd kk:mm:ss").format(Date())  // time에서 kk 사용시 24시간제로 출력됨
            }
        }
    }
    */

}